package org.greport;

import java.awt.Color;
import static org.greport.HAlignment.CENTER;

/**
 *
 * @author Marcius
 */
public class ColumnHeader extends Column {

    private HAlignment titleHAlignment = CENTER;

    private Font titleFont = new Font();
    private final Decorator titleBorders = new Decorator();

    public ColumnHeader(LayoutGrid grid, Row row) {
        super(grid, row, null);

        super.getFont().setParent(grid.getFont());
        super.getDecorator().setParent(grid.getDecorator());

        titleFont.setParent(grid.getTitleFont());
        titleBorders.setParent(grid.getTitleBorders());
    }

    //<editor-fold defaultstate="collapsed" desc="Header Title Font">
    public Font getTitleFont() {
        return titleFont;
    }

    public void setTitleFont(Font titleFont) {
        this.titleFont = titleFont;
    }

    public String getTitleFontName() {
        return titleFont.getName();
    }

    public void setTitleFontName(String name) {
        this.titleFont.setName(name);
    }

    public Integer getTitleFontSize() {
        return titleFont.getSize();
    }

    public void setTitleFontSize(Integer size) {
        this.titleFont.setSize(size);
    }

    public Boolean isTitleFontBold() {
        return titleFont.getBold();
    }

    public void setTitleFontBold() {
        this.titleFont.setBold(true);
    }

    public Boolean isTitleFontItalic() {
        return titleFont.getItalic();
    }

    public void setTitleFontItalic() {
        this.titleFont.setItalic(true);
    }

    public Boolean isTitleFontUnderline() {
        return titleFont.getUnderline();
    }

    public void setTitleFontUnderline() {
        this.titleFont.setUnderline(true);
    }

    public Color getTitleFontColor() {
        return titleFont.getColor();
    }

    public void setTitleFontColor(Color color) {
        this.titleFont.setColor(color);
    }

    public Color getTitleBackgroundColor() {
        return titleFont.getBackgroundColor();
    }

    public void setTitleBackgroundColor(Color color) {
        this.titleFont.setBackgroundColor(color);
    }
    //</editor-fold>

    public Borders getTitleBorderTop() {
        return titleBorders.getBorderTop();
    }

    public void setTitleBorderTop(Borders titleBorderTop) {
        this.titleBorders.setBorderTop(titleBorderTop);
    }

    public Borders getTitleBorderRight() {
        return titleBorders.getBorderRight();
    }

    public void setTitleBorderRigth(Borders borderRight) {
        this.titleBorders.setBorderRight(borderRight);
    }

    public Borders getTitleBorderBottom() {
        return titleBorders.getBorderBottom();
    }

    public void setTitleBorderBottom(Borders titleBorderBottom) {
        this.titleBorders.setBorderBottom(titleBorderBottom);
    }

    public Borders getTitleBorderLeft() {
        return titleBorders.getBorderLeft();
    }

    public void setTitleBorderLeft(Borders titleBorderLeft) {
        this.titleBorders.setBorderLeft(titleBorderLeft);
    }

    public HAlignment getTitleHAlignment() {
        return titleHAlignment;
    }

    public void setTitleHAlignment(HAlignment titlehAlignment) {
        this.titleHAlignment = titlehAlignment;
    }

    @Override
    public Column setBackgroundColor(Color backgroundColor) {
        titleFont.setBackgroundColor(backgroundColor.darker());
        return super.setBackgroundColor(backgroundColor);
    }

}
