package org.greport.pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.image.ImageData;
import static org.greport.Report.Orientation.PORTRAIT;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import org.greport.Column;
import org.greport.LayoutGrid;
import org.greport.Report;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.ILeafElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.greport.Util;
import static org.greport.Util.isPresent;

public class ReportExporterPDF {

    public static void exportTo(Report reader, File file) throws IOException {
        exportTo(reader, new PdfWriter(file));
    }

    public static void exportTo(Report reader, OutputStream outputStream) throws IOException {
        exportTo(reader, new PdfWriter(outputStream));
    }

    public static void exportToPdf(Report reader, String fileName) throws IOException {
        exportTo(reader, new PdfWriter(fileName));
    }

    public static void exportTo(Report report, PdfWriter pdfWriter) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(pdfWriter);

        float topMargin = report.getTopMargin();
        float rightMargin = report.getRightMargin();
        float bottomMargin = report.getBottomMargin();
        float leftMargin = report.getLeftMargin();
        PageSize pageSize = report.getOrientation().equals(PORTRAIT) ? PageSize.A4 : PageSize.A4.rotate();
        if (isPresent(report.getPageWidth()) && isPresent(report.getPageHeight())) {
            pageSize = new PageSize(report.getPageWidth(), report.getPageHeight());
        }

        try (Document doc = new Document(pdfDoc, pageSize)) {
            // Configura Header do Relat?rio
            if (report.getHeaderGrid() != null) {
                HeaderEventHandler handler = new HeaderEventHandler(doc, report.getHeaderGrid());
                pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, handler);
                topMargin += handler.getTableHeight(); //Aumenta margem para inserir o header
            }

            //configura Footer do Relat?rio
            if (report.getFooterGrid() != null) {
                FooterEventHandler footer = new FooterEventHandler(doc, report.getFooterGrid());
                pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, footer);
                bottomMargin += footer.getTableHeight(); //Aumenta margem para inserir o footer
            }

            //Configura a imagem de fundo
            if (isPresent(report.getBackgroundFileName())) {
                ImageData imageData = ImageDataFactory.create(report.getBackgroundFileName());
                Image img = new Image(imageData).scaleAbsolute(pageSize.getWidth(), pageSize.getHeight());
                BackgroundEventHandler background = new BackgroundEventHandler(img);
                pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, background);
            }

            doc.setMargins(topMargin, rightMargin, bottomMargin, leftMargin);

            Paragraph pTitles = new Paragraph();
            for (String title : report.getTitles()) {
                pTitles.add(title);

                pTitles.setFontSize(report.getTitleFontSize());
                if (report.getTitleFontHAlignment() != null) {
                    pTitles.setTextAlignment(TextAlignment.valueOf(report.getTitleFontHAlignment().name()));
                }

                if (report.isTitleFontBold()) {
                    pTitles.setBold();
                }

                if (report.isTitleFontItalic()) {
                    pTitles.setItalic();
                }

                if (report.isTitleFontUnderline()) {
                    pTitles.setUnderline();
                }
            }

            doc.add(pTitles);

            for (LayoutGrid grid : report.getGrids()) {
                for (int i = 0; i < grid.getPagesBlankBefore(); i++) {
                    doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                }

                Table table = createTable(grid);
                doc.add(table);

                for (int i = 0; i < grid.getPagesBlankAfter(); i++) {
                    doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                }
            }
        }
    }

    public static Table createTable(LayoutGrid grid) {
        /**
         * Configura os tamanhos das colunas
         */
        boolean hasHeader = false;
        float[] widths = new float[grid.getColumnsCount()];
        List<Cell> headers = new LinkedList<>();
        while (grid.hasNextHeader()) {
            Float width = grid.getCurrentHeaderColumn().getWidth();
            widths[grid.getCurrentHeaderColumn().getOrder()] = (width == null ? 1f : width);

            Column headerColumn = grid.getCurrentHeaderColumn();
            if (headerColumn.getValue() != null) {
                hasHeader = true;
            }
        }

        if (hasHeader) {
            while (grid.hasNextHeader()) {
                headers.add(createCellFromColumn(grid.getCurrentHeaderColumn()));
            }
        }

        UnitValue[] unitValue = UnitValue.createPercentArray(widths);
        Table table = new Table(unitValue)
                .setBorderTop(CellAdapter.contertBorder(grid.getBorderTop()))
                .setBorderRight(CellAdapter.contertBorder(grid.getBorderRight()))
                .setBorderBottom(CellAdapter.contertBorder(grid.getBorderBottom()))
                .setBorderLeft(CellAdapter.contertBorder(grid.getBorderLeft()))
                .useAllAvailableWidth();

        /* cria as colunas*/
        headers.forEach((cell) -> {
            table.addHeaderCell(cell);
        });

        //Fill        
        while (grid.hasNextRow()) {
            while (grid.hasNextColumn()) {
                Column column = grid.getCurrentColumn();
                Cell cell = createCellFromColumn(column);
                table.addCell(cell);
            }
        }

        return table;
    }

    private static Cell createCellFromColumn(Column column) throws RuntimeException {

        CellAdapter adapter = new CellAdapter(column);

        Paragraph paragraph = new Paragraph();
        if (column.getValue() instanceof byte[]) {
            byte[] ab = (byte[]) column.getValue();
            Image img = new Image(ImageDataFactory.createPng(ab));
            paragraph.add(img);
        } else if (column.getValue() != null && Util.isDecimal(column.getValue().getClass())) {
            paragraph.add(Util.formatDecimal(column.getValue()));
        } else {
            String value = column.getValue() == null ? "" : column.getValue().toString();
            if (column.isEscape()) {
                ConverterProperties properties = new ConverterProperties();
                try {
                    List<IElement> elements = HtmlConverter.convertToElements(value, properties);
                    for (IElement element : elements) {
                        if (element instanceof Paragraph) {
                            paragraph.add((Paragraph) element);
                        } else if (element instanceof Table) {
                            paragraph.add((Table) element);
                        } else if (element instanceof IBlockElement) {
                            paragraph.add((IBlockElement) element);
                        } else if (element instanceof ILeafElement) {
                            paragraph.add((ILeafElement) element);
                        } else {
                            Logger.getLogger(ReportExporterPDF.class.getName()).log(Level.WARNING, "no Paragraph element");
                        }
                    }
                } catch (IOException ex) {
                    paragraph.add(value);
                    Logger.getLogger(ReportExporterPDF.class.getName()).log(Level.WARNING, null, ex);
                }
            } else {
                paragraph.add(value);
            }
        }

        Cell cell = new Cell();

        if (isPresent(column.getRow()) && isPresent(column.getRow().getHeight())) {
            cell.setHeight(column.getRow().getHeight());
        }

        if (adapter.getPdfFontName() != null) {
            cell.setFont(adapter.getPdfFontName());
        }

        if (adapter.getPdfFontSize() != null) {
            cell.setFontSize(adapter.getPdfFontSize());
        }

        if (adapter.getPdfFontColor() != null) {
            cell.setFontColor(adapter.getPdfFontColor());
        }

        if (adapter.getPdfBackgroudColor() != null) {
            cell.setBackgroundColor(adapter.getPdfBackgroudColor());
        }

        if (Boolean.TRUE.equals(adapter.getPdfFontBold())) {
            cell.setBold();
        }
        if (Boolean.TRUE.equals(adapter.getPdfFontItalic())) {
            cell.setItalic();
        }
        if (Boolean.TRUE.equals(adapter.getPdfFontUnderline())) {
            cell.setUnderline();
        }

        cell.setTextAlignment(adapter.getPdfTextAlignment())
                .setVerticalAlignment(adapter.getPdfVerticalAlignment())
                .add(paragraph);

        //<editor-fold defaultstate="collapsed" desc="set Borders">
        if (column.getBorderTop() != null) {
            cell.setBorderTop(adapter.getPdfBorderTop());
        }

        if (column.getBorderRight() != null) {
            cell.setBorderRight(adapter.getPdfBorderRight());
        }

        if (column.getBorderTop() != null) {
            cell.setBorderBottom(adapter.getPdfBorderBottom());
        }

        if (column.getBorderLeft() != null) {
            cell.setBorderLeft(adapter.getPdfBorderLeft());
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="set Paddings">
        if (column.getDecorator().getPaddingTop() != null) {
            cell.setPaddingTop(column.getDecorator().getPaddingTop());
        }

        if (column.getDecorator().getPaddingRight() != null) {
            cell.setPaddingRight(column.getDecorator().getPaddingRight());
        }

        if (column.getDecorator().getPaddingBottom() != null) {
            cell.setPaddingBottom(column.getDecorator().getPaddingBottom());
        }

        if (column.getDecorator().getPaddingLeft() != null) {
            cell.setPaddingLeft(column.getDecorator().getPaddingLeft());
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="set Margins">
        if (column.getDecorator().getMarginTop() != null) {
            cell.setMarginTop(column.getDecorator().getMarginTop());
        }

        if (column.getDecorator().getMarginRight() != null) {
            cell.setMarginRight(column.getDecorator().getMarginRight());
        }

        if (column.getDecorator().getMarginBottom() != null) {
            cell.setMarginBottom(column.getDecorator().getMarginBottom());
        }

        if (column.getDecorator().getMarginLeft() != null) {
            cell.setMarginLeft(column.getDecorator().getMarginLeft());
        }
        //</editor-fold>

        return cell;
    }

}
