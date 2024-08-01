package org.greport;

import java.awt.Color;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Marcius
 */
public class Row implements Serializable {

    private static final long serialVersionUID = 5695376929233689157L;

    private LayoutGrid grid;
    private Float height;
    private List<Column> columns = new LinkedList<>();
    private Font font = new Font();
    private final Decorator decorator = new Decorator();

    public Row(LayoutGrid grid) {
        this.grid = grid;
    }

    public Float getHeight() {
        return height;
    }

    public Row setHeight(Float height) {
        this.height = height;
        return this;
    }
    
    public LayoutGrid getGrid() {
        return grid;
    }

    public void setGrid(LayoutGrid grid) {
        this.grid = grid;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    //<editor-fold defaultstate="collapsed" desc="Row Font">


    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public String getFontName() {
        return font.getName();
    }

    public Row setFontName(String name) {
        this.font.setName(name);
        return this;
    }

    public Integer getFontSize() {
        return font.getSize();
    }

    public Row setFontSize(Integer size) {
        this.font.setSize(size);
        return this;
    }

    public Boolean getFontBold() {
        return font.getBold();
    }

    public Row setFontBold() {
        this.font.setBold(true);
        return this;
    }

    public Boolean getFontItalic() {
        return font.getItalic();
    }

    public Row setFontItalic() {
        this.font.setItalic(true);
        return this;
    }

    public Boolean getFontUnderline() {
        return font.getUnderline();
    }

    public Row setFontUnderline() {
        this.font.setUnderline(true);
        return this;
    }

    public Color getFontColor() {
        return font.getColor();
    }

    public Row setFontColor(Color color) {
        this.font.setColor(color);
        return this;
    }

    public Color getBackgroundColor() {
        return font.getBackgroundColor();
    }

    public Row setBackgroundColor(Color color) {
        this.font.setBackgroundColor(color);
        return this;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Bordes, Margins and Paddings">

    public Decorator getDecorator() {
        return decorator;
    }

    public Row setBorder(Borders border) {
        decorator.setBorder(border);
        return this;
    }

    public Borders getBorderTop() {
        return decorator.getBorderTop();
    }

    public Row setBorderTop(Borders borderTop) {
        decorator.setBorderTop(borderTop);
        return this;
    }

    public Borders getBorderRight() {
        return decorator.getBorderRight();
    }

    public Row setBorderRigth(Borders borderRight) {
        decorator.setBorderRight(borderRight);
        return this;
    }

    public Borders getBorderBottom() {
        return decorator.getBorderBottom();
    }

    public Row setBorderBottom(Borders borderBottom) {
        decorator.setBorderBottom(borderBottom);
        return this;
    }

    public Borders getBorderLeft() {
        return decorator.getBorderLeft();
    }

    public Row setBorderLeft(Borders borderLeft) {
        decorator.setBorderLeft(borderLeft);
        return this;
    }
    
    public Row setPaddingTop(float padding){
        getDecorator().setPaddingTop(padding);
        return this;
    }
    
    public Row setPaddingRight(float padding){
        getDecorator().setPaddingRight(padding);
        return this;
    }
    
    public Row setPaddingBottom(float padding){
        getDecorator().setPaddingBottom(padding);
        return this;
    }
    
    public Row setPaddingLeft(float padding){
        getDecorator().setPaddingLeft(padding);
        return this;
    }
    
    public Row setPaddings(float padding){
        getDecorator().setPaddings(padding);
        return this;
    }
    
    public Row setPaddings(float top, float right, float bottom, float left) {
        getDecorator().setPaddings(top, right, bottom, left);
        return this;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Fluent Interface">
    public Column addValue() {
        return grid.addValue();
    }

    public Column addValue(Object value) {
        return grid.addValue(value);
    }

    public Column addValues(Object... values) {
        Column column = null;
        for (Object value : values) {
            column = grid.addValue(value);
        }
        return column;
    }
//</editor-fold>

    public Row addRow(Object... values) {
        return grid.addRow(values);
    }
}
