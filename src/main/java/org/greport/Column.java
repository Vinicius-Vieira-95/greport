package org.greport;

import java.awt.Color;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcius
 */
public class Column implements Serializable {

    private static final long serialVersionUID = -8111638233844110167L;

    private final LayoutGrid grid;

    private final Row row;

    private ColumnHeader headerColumn;

    private int order;

    private Object value;

    private boolean escape = false;

    private Float width;

    private Operation[] operations;
    private Integer operationCount;
    private BigDecimal operationSum;
    private BigDecimal operationMax;
    private BigDecimal operationMin;
    private List<BigDecimal> operationAverage;

    private HAlignment hAlign;
    private VAlignment vAlign;

    private Font font = new Font();
    private final Decorator decorator = new Decorator();

    public Column(LayoutGrid grid, Row row, ColumnHeader headerColumn) {
        this.grid = grid;
        this.row = row;
        this.headerColumn = headerColumn;
        if (row != null) {
            font.setParent(row.getFont());
            decorator.setParent(row.getDecorator());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Bordes, Margins and Paddings">
    public Column setMargins(float margin) {
        decorator.setMargins(margin, margin, margin, margin);
        return this;
    }

    public Column setMargins(float top, float right, float bottom, float left) {
        decorator.setMargins(top, right, bottom, left);
        return this;
    }

    public Column setPaddings(float paddind) {
        decorator.setPaddings(paddind, paddind, paddind, paddind);
        return this;
    }

    public Column setPaddings(float top, float right, float bottom, float left) {
        decorator.setPaddings(top, right, bottom, left);
        return this;
    }

    public Decorator getDecorator() {
        return decorator;
    }

    public Column setBorder(Borders border) {
        decorator.setBorder(border);
        return this;
    }

    public Borders getBorderTop() {
        if (decorator.getBorderTop() == null && headerColumn != null) {
            return headerColumn.getBorderTop();
        }
        return decorator.getBorderTop();
    }

    public Column setBorderTop(Borders borderTop) {
        decorator.setBorderTop(borderTop);
        return this;
    }

    public Borders getBorderRight() {
        if (decorator.getBorderRight() == null && headerColumn != null) {
            return headerColumn.getBorderRight();
        }
        return decorator.getBorderRight();
    }

    public Column setBorderRigth(Borders borderRight) {
        decorator.setBorderRight(borderRight);
        return this;
    }

    public Borders getBorderBottom() {
        if (decorator.getBorderBottom() == null && headerColumn != null) {
            return headerColumn.getBorderBottom();
        }

        return decorator.getBorderBottom();
    }

    public Column setBorderBottom(Borders borderBottom) {
        decorator.setBorderBottom(borderBottom);
        return this;
    }

    public Borders getBorderLeft() {
        if (decorator.getBorderLeft() == null && headerColumn != null) {
            return headerColumn.getBorderLeft();
        }

        return decorator.getBorderLeft();
    }

    public Column setBorderLeft(Borders borderLeft) {
        decorator.setBorderLeft(borderLeft);
        return this;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Column Font">
    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public String getFontName() {
        if (font.getName() == null && headerColumn != null) {
            return headerColumn.getFontName();
        }
        return font.getName();
    }

    public Column setFontName(String name) {
        this.font.setName(name);
        return this;
    }

    public Integer getFontSize() {
        if (font.getSize() == null && headerColumn != null) {
            return headerColumn.getFontSize();
        } else {
            return font.getSize();
        }
    }

    public Column setFontSize(Integer size) {
        this.font.setSize(size);
        return this;
    }

    public Boolean isFontBold() {
        if (font.getBold() == null && headerColumn != null) {
            return headerColumn.isFontBold();
        }
        return font.getBold();
    }

    public Column setFontBold() {
        this.font.setBold(true);
        return this;
    }

    public Boolean isFontItalic() {
        if (font.getItalic() == null && headerColumn != null) {
            return headerColumn.isFontItalic();
        }
        return font.getItalic();
    }

    public Column setFontItalic() {
        this.font.setItalic(true);
        return this;
    }

    public Boolean isFontUnderline() {
        if (font.getUnderline() == null && headerColumn != null) {
            return headerColumn.isFontUnderline();
        }
        return font.getUnderline();
    }

    public Column setFontUnderline() {
        this.font.setUnderline(true);
        return this;
    }

    public Color getFontColor() {
        if (font.getColor() == null && headerColumn != null) {
            return headerColumn.getFontColor();
        }
        return font.getColor();
    }

    public Column setFontColor(Color color) {
        this.font.setColor(color);
        return this;
    }

    public Color getBackgroundColor() {
        if (font.getBackgroundColor() == null && headerColumn != null) {
            return headerColumn.getBackgroundColor();
        }
        return font.getBackgroundColor();
    }

    public Column setBackgroundColor(Color backgroundColor) {
        font.setBackgroundColor(backgroundColor);
        return this;
    }
//</editor-fold>

    public Row getRow() {
        return row;
    }

    public Column getHeaderColumn() {
        return headerColumn;
    }

    protected Column setHeaderColumn(ColumnHeader headerColumn) {
        this.headerColumn = headerColumn;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Object getValue() {
        return value;
    }

    /**
     * If the "escape" attribute is "false"<br>
     * the value of column should be rendered as text without escaping HTML tags.
     *
     * @return escape
     */
    public boolean isEscape() {
        return escape;
    }

    public void setEscape(boolean escape) {
        this.escape = escape;
    }

    public Column setValue(Object value) {
        this.value = value;
        return this;
    }

    public Float getWidth() {
        if (width == null && headerColumn != null) {
            return headerColumn.getWidth();
        }
        return width;
    }

    public Column setWidth(Float width) {
        this.width = width;
        return this;
    }

    //<editor-fold defaultstate="collapsed" desc="get e sets do Horizontal Alignment">
    public HAlignment gethAlign() {
        if (hAlign == null && headerColumn != null) {
            return headerColumn.gethAlign();
        }
        return hAlign;
    }

    public Column sethAlign(HAlignment textAlignment) {
        this.hAlign = textAlignment;
        return this;
    }

    public Column sethAlignLeft() {
        this.hAlign = HAlignment.LEFT;
        return this;
    }

    public Column sethAlignCenter() {
        this.hAlign = HAlignment.CENTER;
        return this;
    }

    public Column sethAlignRight() {
        this.hAlign = HAlignment.RIGHT;
        return this;
    }

    public Column sethAlignJustified() {
        this.hAlign = HAlignment.JUSTIFIED;
        return this;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get e sets do Vertical Alignment">
    public VAlignment getvAlign() {
        if (vAlign == null && headerColumn != null) {
            return headerColumn.getvAlign();
        }
        return vAlign;
    }

    public void setvAlign(VAlignment vAlign) {
        this.vAlign = vAlign;
    }

    public Column setVAlignMiddle() {
        this.vAlign = VAlignment.MIDDLE;
        return this;
    }

    public Column setVAlignTop() {
        this.vAlign = VAlignment.TOP;
        return this;
    }

    public Column setVAlignBottom() {
        this.vAlign = VAlignment.BOTTOM;
        return this;
    }
    //</editor-fold>

    public Integer getOperationCount() {
        return operationCount;
    }

    public BigDecimal getOperationSum() {
        return operationSum;
    }

    public BigDecimal getOperationMax() {
        return operationMax;
    }

    public BigDecimal getOperationMin() {
        return operationMin;
    }

    public BigDecimal getOperationAverage() {
        BigDecimal average = BigDecimal.ZERO;
        for (BigDecimal bigDecValue : operationAverage) {
            average = bigDecValue.add(average);
        }

        return average.divide(BigDecimal.valueOf(operationAverage.size()), RoundingMode.HALF_UP);
    }

    public Column setOperations(Operation... operations) {
        this.operations = operations;

        /**
         * Inicializa os operadores
         */
        operationCount = null;
        operationSum = null;
        operationMax = null;
        operationMin = null;
        if (operations != null) {
            for (Operation operation : operations) {
                switch (operation) {
                    case COUNT:
                        operationCount = 0;
                        break;
                    case SUM:
                        operationSum = BigDecimal.ZERO;
                        break;
                    case HIGHEST:
                        operationMax = BigDecimal.ZERO;
                        break;
                    case LOWEST:
                        operationMin = null;
                        break;
                    case AVERAGE:
                        operationAverage = new ArrayList<>();
                        break;
                    default:
                        break;
                }
            }
        }
        return this;
    }

    public Operation[] getOperations() {
        return operations;
    }

    //<editor-fold defaultstate="collapsed" desc="fluent interface com layoutGrid">
    public LayoutGrid getGrid() {
        return grid;
    }

    public Column addValue() {
        return grid.addValue(null);
    }

    public Column addValue(Object value) {
        return grid.addValue(value);
    }

    /**
     * Set "escape" attribute to "false"<br>
     * The value of column should be rendered as text without escaping HTML tags.
     *
     * @return current Column
     */
    public Column noEscape() {
        escape = false;
        return this;
    }

    /**
     * Set "escape" attribute to "true"<br>
     * The value of column should be rendered as HTML, escaping HTML tags.
     *
     * @return current Column
     */
    public Column escape() {
        escape = true;
        return this;
    }

    public Row addRow() {
        return grid.addRow();
    }

    /**
     * Adiciona Linhas com conteudo em lote
     *
     * @param values
     * @return
     */
    public Row addRows(Object... values) {
        int count = 0;
        Row r = grid.addRow();
        for (Object v : values) {
            if (count == grid.getColumnsCount()) {
                r = grid.addRow();
                count = 0;
            }
            r.addValue(v);
            count++;
        }
        return r;
    }

    /**
     * Adiciona colunas em lote em uma nova linha
     *
     * @param values
     * @return
     */
    public Row addRow(Object... values) {
        Row r = grid.addRow();
        r.addValues(values);
        return r;
    }

    public Column addColumn() {
        return grid.addColumn();
    }

    public Column addColumn(String value) {
        return grid.addColumn(value);
    }
    //</editor-fold>

    void applyOperations(Object value) {
        if (operations != null && value != null) {
            for (Operation operation : operations) {
                switch (operation) {
                    case COUNT:
                        operationCount++;
                        break;
                    case SUM:
                        operationSum = operationSum.add(Util.toBigDecimal(value));
                        break;
                    case HIGHEST:
                        operationMax = operationMax.max(Util.toBigDecimal(value));
                        break;
                    case LOWEST:
                        if (operationMin == null) {
                            operationMin = Util.toBigDecimal(value);
                        } else {
                            operationMin = operationMin.min(Util.toBigDecimal(value));
                        }
                        break;
                    case AVERAGE:
                        operationAverage.add(Util.toBigDecimal(value));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.order;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Column other = (Column) obj;
        return this.order == other.order;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        if (headerColumn != null) {
            s.append("\n headerColumn=" + "*");
        }
        s.append("\n order=").append(order);
        s.append("\n value=").append(value.toString());

        if (gethAlign() != null) {
            s.append("\n hAlign=").append(hAlign != null ? hAlign : "->" + gethAlign());
        }

        if (getvAlign() != null) {
            s.append("\n vAlign=").append(vAlign != null ? vAlign : "->" + getvAlign());
        }

        if (getWidth() != null) {
            s.append("\n width=").append(width != null ? width : "->" + getWidth());
        }

        //+ "\n operations=" + operations
        //+ "\n operationCount=" + operationCount
        //+ "\n operationSum=" + operationSum
        //+ "\n operationMax=" + operationMax
        //+ "\n operationMin=" + operationMin
        //+ "\n operationAverage=" + operationAverage
        if (getFontName() != null) {
            s.append("\n FontName=").append(getFont().toString());
        }

        s.append(decorator.toString());
        return s.toString();

    }

}
