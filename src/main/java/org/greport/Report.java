package org.greport;

import static org.greport.Font.HELVETICA;

import java.awt.Color;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marcius.brandao
 */
public class Report implements Serializable {

    private static final long serialVersionUID = 4525374847074586619L;

    public enum Orientation {
        PORTRAIT, LANDSCAPE
    }

    private final List<String> titles = new LinkedList<>();
    private Float pageWidth;
    private Float pageHeight;
    private float topMargin = 10;
    private float rightMargin = 10;
    private float bottomMargin = 10;
    private float leftMargin = 10;
    private String backgroundFileName;
    private Orientation orientation = Orientation.PORTRAIT;

    private LayoutGrid headerGrid;
    private final List<LayoutGrid> grids = new LinkedList<>();
    private LayoutGrid footerGrid;
    private LayoutGrid currentGrid;

    private final Decorator decorator = new Decorator();
    private final Decorator titleDecorator = new Decorator();

    public Report() {
        font.setName(HELVETICA);
        font.setSize(10);

        titleFont.setSize(12);
        titleFont.setBold(true);
        titleFont.setName(HELVETICA);
        titleFont.setBackgroundColor(Color.LIGHT_GRAY);
    }

    //<editor-fold defaultstate="collapsed" desc="Report Titles Font">
    private Font titleFont = new Font();

    public Font getTitleFont() {
        return titleFont;
    }

    public Report setTitleFont(Font titleFont) {
        this.titleFont = titleFont;
        return this;
    }

    public String getTitleFontName() {
        return titleFont.getName();
    }

    public Report setTitleFontName(String name) {
        this.titleFont.setName(name);
        return this;
    }

    public Integer getTitleFontSize() {
        return titleFont.getSize();
    }

    public Report setTitleFontSize(Integer size) {
        this.titleFont.setSize(size);
        return this;
    }

    public boolean isTitleFontBold() {
        return Boolean.TRUE.equals(titleFont.getBold());
    }

    public Report setTitleFontBold() {
        this.titleFont.setBold(true);
        return this;
    }

    public boolean isTitleFontItalic() {
        return Boolean.TRUE.equals(titleFont.getItalic());
    }

    public Report setTitleFontItalic() {
        this.titleFont.setItalic(true);
        return this;
    }

    public boolean isTitleFontUnderline() {
        return Boolean.TRUE.equals(titleFont.getUnderline());
    }

    public Report setTitleFontUnderline() {
        this.titleFont.setUnderline(true);
        return this;
    }

    public Color getTitleFontColor() {
        return titleFont.getColor();
    }

    public Report setTitleFontColor(Color color) {
        this.titleFont.setColor(color);
        return this;
    }

    public Color getTitleBackgroundColor() {
        return titleFont.getBackgroundColor();
    }

    public Report setTitleBackgroundColor(Color color) {
        this.titleFont.setBackgroundColor(color);
        return this;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Report Font">
    private final Font font = new Font(Font.HELVETICA, 11);

    public Font getFont() {
        return font;
    }

    public String getFontName() {
        return font.getName();
    }

    public Report setFontName(String name) {
        this.font.setName(name);
        return this;
    }

    public Integer getFontSize() {
        return font.getSize();
    }

    public Report setFontSize(Integer size) {
        this.font.setSize(size);
        return this;
    }

    public Report setFontBold() {
        font.setBold(Boolean.TRUE);
        return this;
    }

    public Boolean isFontBold() {
        return font.getBold();
    }

    public Report setFontItalic() {
        font.setItalic(Boolean.TRUE);
        return this;
    }

    public Boolean isFontItalic() {
        return font.getItalic();
    }

    public Report setFontUnderline() {
        font.setUnderline(Boolean.TRUE);
        return this;
    }

    public Boolean isFontUnderline() {
        return font.getUnderline();
    }

    public Color getFontColor() {
        return font.getColor();
    }

    public Report setFontColor(Color color) {
        this.font.setColor(color);
        return this;
    }

    public Color getBackgroundColor() {
        return font.getBackgroundColor();
    }

    public Report setBackgroundColor(Color color) {
        this.font.setBackgroundColor(color);
        return this;
    }

    public Report setTitleFontHAlignment(HAlignment hAlignment) {
        this.font.sethAlignment(hAlignment);
        return this;
    }

    public HAlignment getTitleFontHAlignment() {
        return this.font.gethAlignment();
    }

//</editor-fold>
    
    public Report addNewPage() {
        if (grids.size() > 0) {
            grids.get(grids.size() - 1).addNewPage();
        }
        return this;
    }

    public Report addTitle(String title) {
        titles.add(title);
        return this;
    }

    public List<String> getTitles() {
        return titles;
    }

    public Report setPageSize(Float width, Float heitgh) {
        setPageWidth(width);
        setPageHeight(heitgh);
        return this;
    }

    public Float getPageWidth() {
        return pageWidth;
    }

    public Report setPageWidth(Float pageWidth) {
        this.pageWidth = pageWidth;
        return this;
    }

    public Float getPageHeight() {
        return pageHeight;
    }

    public Report setPageHeight(Float pageHeight) {
        this.pageHeight = pageHeight;
        return this;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Report setOrientation(Orientation orientation) {
        this.orientation = orientation;
        return this;
    }

    public String getBackgroundFileName() {
        return backgroundFileName;
    }

    public Report setBackgroundFileName(String backgroundFileName) {
        this.backgroundFileName = backgroundFileName;
        return this;
    }

    public float getTopMargin() {
        return topMargin;
    }

    public Report setTopMargin(float topMargin) {
        this.topMargin = topMargin;
        return this;
    }

    public float getRightMargin() {
        return rightMargin;
    }

    public Report setRightMargin(float rightMargin) {
        this.rightMargin = rightMargin;
        return this;
    }

    public float getBottomMargin() {
        return bottomMargin;
    }

    public Report setBottomMargin(float bottomMargin) {
        this.bottomMargin = bottomMargin;
        return this;
    }

    public float getLeftMargin() {
        return leftMargin;
    }

    public Report setLeftMargin(float leftMargin) {
        this.leftMargin = leftMargin;
        return this;
    }

    public Report setMargins(float margin) {
        bottomMargin = margin;
        leftMargin = margin;
        rightMargin = margin;
        topMargin = margin;
        return this;
    }

    public Report setMargins(float topMargin, float rightMargin, float bottomMargin, float leftMargin) {
        this.bottomMargin = bottomMargin;
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
        this.topMargin = topMargin;
        return this;
    }

    public List<LayoutGrid> getGrids() {
        return grids;
    }

    public LayoutGrid addGrid() {
        currentGrid = new LayoutGrid(this);
        grids.add(currentGrid);
        return currentGrid;
    }

    public LayoutGrid addHeaderGrid() {
        headerGrid = new LayoutGrid(this);
        return headerGrid;
    }

    public LayoutGrid addFooterGrid() {
        footerGrid = new LayoutGrid(this);
        return footerGrid;
    }

    public LayoutGrid getHeaderGrid() {
        return headerGrid;
    }

    public LayoutGrid getFooterGrid() {
        return footerGrid;
    }

    //<editor-fold defaultstate="collapsed" desc="Bordes, Margins and Paddings">
    public Decorator getDecorator() {
        return decorator;
    }

    public Report setBorder(Borders border) {
        decorator.setBorder(border);
        return this;
    }

    public Borders getBorderTop() {
        return decorator.getBorderTop();
    }

    public Report setBorderTop(Borders borderTop) {
        decorator.setBorderTop(borderTop);
        return this;
    }

    public Borders getBorderRight() {
        return decorator.getBorderRight();
    }

    public Report setBorderRigth(Borders borderRight) {
        decorator.setBorderRight(borderRight);
        return this;
    }

    public Borders getBorderBottom() {
        return decorator.getBorderBottom();
    }

    public Report setBorderBottom(Borders borderBottom) {
        decorator.setBorderBottom(borderBottom);
        return this;
    }

    public Borders getBorderLeft() {
        return decorator.getBorderLeft();
    }

    public Report setBorderLeft(Borders borderLeft) {
        decorator.setBorderLeft(borderLeft);
        return this;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Titles Bordes, Margins and Paddings">
    public Decorator getTitleDecorator() {
        return titleDecorator;
    }

    public Borders getTitleBorderTop() {
        return titleDecorator.getBorderTop();
    }

    public void setTitleBorderTop(Borders titleBorderTop) {
        this.titleDecorator.setBorderTop(titleBorderTop);
    }

    public Borders getTitleBorderRight() {
        return titleDecorator.getBorderRight();
    }

    public void setTitleBorderRigth(Borders borderRight) {
        this.titleDecorator.setBorderRight(borderRight);
    }

    public Borders getTitleBorderBottom() {
        return titleDecorator.getBorderBottom();
    }

    public void setTitleBorderBottom(Borders titleBorderBottom) {
        this.titleDecorator.setBorderBottom(titleBorderBottom);
    }

    public Borders getTitleBorderLeft() {
        return titleDecorator.getBorderLeft();
    }

    public void setTitleBorderLeft(Borders titleBorderLeft) {
        this.titleDecorator.setBorderLeft(titleBorderLeft);
    }
//</editor-fold>
}
