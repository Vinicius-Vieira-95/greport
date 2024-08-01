package org.greport.pdf;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.DottedBorder;
import com.itextpdf.layout.borders.DoubleBorder;
import com.itextpdf.layout.borders.GrooveBorder;
import com.itextpdf.layout.borders.InsetBorder;
import com.itextpdf.layout.borders.RidgeBorder;
import com.itextpdf.layout.borders.RoundDotsBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.greport.Column;
import org.greport.ColumnHeader;
import org.greport.HAlignment;
import org.greport.VAlignment;

/**
 *
 * @author marcius.brandao
 */
public class CellAdapter {

    private final PdfFont pdfFontName;
    private final Integer pdfFontSize;
    private final Color pdfFontColor;
    private final Color pdfBackgroudColor;
    private final Boolean pdfFontBold;
    private final Boolean pdfFontItalic;
    private final Boolean pdfFontUnderline;
    private final TextAlignment pdfTextAlignment;
    private final VerticalAlignment pdfVerticalAlignment;
    private final Border pdfBorderTop;
    private final Border pdfBorderRight;
    private final Border pdfBorderBottom;
    private final Border pdfBorderLeft;

    public CellAdapter(Column column) {
        if (column instanceof ColumnHeader) {
            ColumnHeader columnHeader = (ColumnHeader) column;

            pdfFontName = createPDFFont(columnHeader.getTitleFontName());
            pdfFontColor = convertToPdfColor(columnHeader.getTitleFontColor());
            pdfBackgroudColor = convertToPdfColor(columnHeader.getTitleBackgroundColor());
            pdfFontSize = columnHeader.getTitleFontSize();
            pdfFontBold = columnHeader.isTitleFontBold();
            pdfFontItalic = columnHeader.isTitleFontItalic();
            pdfFontUnderline = columnHeader.isTitleFontUnderline();

            HAlignment hAlign = columnHeader.getTitleHAlignment();
            pdfTextAlignment = (hAlign == null ? TextAlignment.CENTER : TextAlignment.valueOf(hAlign.name()));

            VAlignment vAlign = columnHeader.getvAlign();
            pdfVerticalAlignment = (vAlign == null ? VerticalAlignment.MIDDLE : VerticalAlignment.valueOf(vAlign.name()));

            pdfBorderTop = contertBorder(columnHeader.getTitleBorderTop());
            pdfBorderRight = contertBorder(columnHeader.getTitleBorderRight());
            pdfBorderBottom = contertBorder(columnHeader.getTitleBorderBottom());
            pdfBorderLeft = contertBorder(columnHeader.getTitleBorderLeft());
        } else {
            pdfFontName = createPDFFont(column.getFontName());
            pdfFontColor = convertToPdfColor(column.getFontColor());
            pdfBackgroudColor = convertToPdfColor(column.getBackgroundColor());
            pdfFontSize = column.getFontSize();
            pdfFontBold = column.isFontBold();
            pdfFontItalic = column.isFontItalic();
            pdfFontUnderline = column.isFontUnderline();

            HAlignment hAlign = column.gethAlign();
            pdfTextAlignment = (hAlign == null ? TextAlignment.LEFT : TextAlignment.valueOf(hAlign.name()));

            VAlignment vAlign = column.getvAlign();
            pdfVerticalAlignment = (vAlign == null ? VerticalAlignment.MIDDLE : VerticalAlignment.valueOf(vAlign.name()));

            pdfBorderTop = contertBorder(column.getBorderTop());
            pdfBorderRight = contertBorder(column.getBorderRight());
            pdfBorderBottom = contertBorder(column.getBorderBottom());
            pdfBorderLeft = contertBorder(column.getBorderLeft());
        }
    }

    private Color convertToPdfColor(java.awt.Color color) {
        if (color == null) {
            return null;
        }
        return new DeviceRgb(color.getRed(), color.getGreen(), color.getBlue());
    }

    private static PdfFont createPDFFont(String fontName) {
        PdfFont font = null;

        try {
            font = PdfFontFactory.createFont(fontName);
        } catch (IOException | java.io.IOException ex) {
            Logger.getLogger(CellAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return font;
    }

    public static com.itextpdf.layout.borders.Border contertBorder(org.greport.Borders b) {
        if (b == null) {
            return null;
        }

        switch (b) {
            case None:
                return Border.NO_BORDER;
            case Dashed:
                return new DashedBorder(1);
            case Dotted:
                return new DottedBorder(1);
            case Double:
                return new DoubleBorder(1);
            case Groove:
                return new GrooveBorder(1);
            case Inset:
                return new InsetBorder(1);
            case Outset:
                return new DottedBorder(1);
            case Ridge:
                return new RidgeBorder(1);
            case RoundDots:
                return new RoundDotsBorder(1);
            default:
                return new SolidBorder(1);
        }
    }

    public PdfFont getPdfFontName() {
        return pdfFontName;
    }

    public Integer getPdfFontSize() {
        return pdfFontSize;
    }

    public Color getPdfFontColor() {
        return pdfFontColor;
    }

    public Color getPdfBackgroudColor() {
        return pdfBackgroudColor;
    }

    public Boolean getPdfFontBold() {
        if (pdfFontBold == null) {
            return false;
        } else {
            return pdfFontBold;
        }
    }

    public Boolean getPdfFontItalic() {
        if (pdfFontItalic == null) {
            return false;
        } else {
            return pdfFontItalic;
        }
    }

    public Boolean getPdfFontUnderline() {
        if (pdfFontUnderline == null) {
            return false;
        } else {
            return pdfFontUnderline;
        }
    }

    public TextAlignment getPdfTextAlignment() {
        return pdfTextAlignment;
    }

    public VerticalAlignment getPdfVerticalAlignment() {
        return pdfVerticalAlignment;
    }
    
    public Border getPdfBorderTop() {
        return pdfBorderTop;
    }

    public Border getPdfBorderRight() {
        return pdfBorderRight;
    }

    public Border getPdfBorderBottom() {
        return pdfBorderBottom;
    }

    public Border getPdfBorderLeft() {
        return pdfBorderLeft;
    }

}
