package org.greport.pdf;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.layout.LayoutArea;
import com.itextpdf.layout.layout.LayoutContext;
import com.itextpdf.layout.layout.LayoutResult;
import com.itextpdf.layout.renderer.DocumentRenderer;
import com.itextpdf.layout.renderer.TableRenderer;
import org.greport.LayoutGrid;

class HeaderEventHandler implements IEventHandler {

    private final Table tableHeader;
    private final float tableHeight;
    private final Document doc;

    public HeaderEventHandler(Document doc, LayoutGrid grid) {
        this.doc = doc;
        tableHeader = ReportExporterPDF.createTable(grid);
        tableHeight = getTableHeight(tableHeader);
    }

    private float getTableHeight(Table table) {
        TableRenderer tableRenderer = (TableRenderer) table.createRendererSubTree();
        tableRenderer.setParent(new DocumentRenderer(doc));
        // Simulate the positioning of the renderer to find out how much space the header table will occupy.
        LayoutResult result = tableRenderer.layout(new LayoutContext(new LayoutArea(0, PageSize.A4)));
        return result.getOccupiedArea().getBBox().getHeight();
    }

    @Override
    public void handleEvent(Event currentEvent) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) currentEvent;
        PdfDocument pdfDoc = docEvent.getDocument();
        PdfPage page = docEvent.getPage();
        int pageNumber = pdfDoc.getPageNumber(page);
        PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);
        PageSize pageSize = pdfDoc.getDefaultPageSize();

        float coordX = pageSize.getX() + doc.getLeftMargin();
        float coordY = pageSize.getTop() - doc.getTopMargin();
        float width = pageSize.getWidth() - doc.getRightMargin() - doc.getLeftMargin();
        float height = getTableHeight();
        Rectangle rect = new Rectangle(coordX, coordY, width, height);
        new Canvas(canvas, pdfDoc, rect).add(tableHeader).close();
    }

    public float getTableHeight() {
        return tableHeight;
    }

}
