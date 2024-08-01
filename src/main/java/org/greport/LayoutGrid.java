package org.greport;

import java.awt.Color;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import static org.greport.Operation.LABEL_COUNT;
import static org.greport.Operation.LABEL_HIGHEST;
import static org.greport.Operation.LABEL_LOWEST;
import static org.greport.Operation.LABEL_SUM;

public class LayoutGrid implements Serializable {

    private final Report report;
    private final List<ColumnHeader> header = new LinkedList<>();
    private final List<Row> rowsData = new LinkedList<>();
    private final List<Row> rowsOperation = new LinkedList<>();

    private Row currentRow;
    private Column currentColumn;
    private ColumnHeader currentHeaderColumn;

    int rowIndex = -1;
    int columnIndex = -1;
    int headerIndex = -1;

    private int pagesBlankBefore = 0;
    private int pagesBlankAfter = 0;

    private Font font = new Font();
    private Font titleFont = new Font();
    private final Decorator decorator = new Decorator();
    private final Decorator titleDecorator = new Decorator();

    protected LayoutGrid(Report report) {
        this.report = report;
        this.font.setParent(report.getFont());
        this.titleFont.setParent(report.getTitleFont());
        this.decorator.setParent(report.getDecorator());
        this.titleDecorator.setParent(report.getTitleDecorator());
    }

    //<editor-fold defaultstate="collapsed" desc="Report Titles Font">
    public Font getTitleFont() {
        return titleFont;
    }

    public LayoutGrid setTitleFont(Font titleFont) {
        this.titleFont = titleFont;
        return this;
    }

    public String getTitleFontName() {
        return titleFont.getName();
    }

    public LayoutGrid setTitleFontName(String name) {
        this.titleFont.setName(name);
        return this;
    }

    public Integer getTitleFontSize() {
        return titleFont.getSize();
    }

    public LayoutGrid setTitleFontSize(Integer size) {
        this.titleFont.setSize(size);
        return this;
    }

    public Boolean isTitleFontBold() {
        return titleFont.getBold();
    }

    public LayoutGrid setTitleFontBold() {
        this.titleFont.setBold(true);
        return this;
    }

    public Boolean isTitleFontItalic() {
        return titleFont.getItalic();
    }

    public LayoutGrid setTitleFontItalic() {
        this.titleFont.setItalic(true);
        return this;
    }

    public Boolean isTitleFontUnderline() {
        return titleFont.getUnderline();
    }

    public LayoutGrid setTitleFontUnderline() {
        this.titleFont.setUnderline(true);
        return this;
    }

    public Color getTitleFontColor() {
        return titleFont.getColor();
    }

    public LayoutGrid setTitleFontColor(Color color) {
        this.titleFont.setColor(color);
        return this;
    }

    public Color getTitleBackgroundColor() {
        return titleFont.getBackgroundColor();
    }

    public LayoutGrid setTitleBackgroundColor(Color color) {
        this.titleFont.setBackgroundColor(color);
        return this;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Bordes, Margins and Paddings">
    public Decorator getDecorator() {
        return decorator;
    }

    public LayoutGrid setBorder(Borders border) {
        decorator.setBorder(border);
        return this;
    }

    public Borders getBorderTop() {
        return decorator.getBorderTop();
    }

    public LayoutGrid setBorderTop(Borders borderTop) {
        decorator.setBorderTop(borderTop);
        return this;
    }

    public Borders getBorderRight() {
        return decorator.getBorderRight();
    }

    public LayoutGrid setBorderRigth(Borders borderRight) {
        decorator.setBorderRight(borderRight);
        return this;
    }

    public Borders getBorderBottom() {
        return decorator.getBorderBottom();
    }

    public LayoutGrid setBorderBottom(Borders borderBottom) {
        decorator.setBorderBottom(borderBottom);
        return this;
    }

    public Borders getBorderLeft() {
        return decorator.getBorderLeft();
    }

    public LayoutGrid setBorderLeft(Borders borderLeft) {
        decorator.setBorderLeft(borderLeft);
        return this;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Titles Bordes, Margins and Paddings">
    public Decorator getTitleBorders() {
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

    //<editor-fold defaultstate="collapsed" desc="Grid Font">
    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public String getFontName() {
        return font.getName();
    }

    public LayoutGrid setFontName(String name) {
        this.font.setName(name);
        return this;
    }

    public LayoutGrid setFontSize(Integer size) {
        this.font.setSize(size);
        return this;
    }

    public Integer getFontSize() {
        return font.getSize();
    }

    public Boolean getFontBold() {
        return font.getBold();
    }

    public LayoutGrid setFontBold() {
        this.font.setBold(true);
        return this;
    }

    public Boolean getFontItalic() {
        return font.getItalic();
    }

    public LayoutGrid setFontItalic() {
        this.font.setItalic(true);
        return this;
    }

    public Boolean getFontUnderline() {
        return font.getUnderline();
    }

    public LayoutGrid setFontUnderline() {
        this.font.setUnderline(true);
        return this;
    }

    public Color getFontColor() {
        return font.getColor();
    }

    public LayoutGrid setFontColor(Color color) {
        this.font.setColor(color);
        return this;
    }

    public Color getBackgroundColor() {
        return font.getBackgroundColor();
    }

    public LayoutGrid setBackgroundColor(Color color) {
        this.font.setBackgroundColor(color);
        return this;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="gets e sets">
    public Column getCurrentColumn() {
        return currentColumn;
    }

    public Column getCurrentHeaderColumn() {
        return currentHeaderColumn;
    }

    public int getPagesBlankBefore() {
        return pagesBlankBefore;
    }

    public void setPagesBlankBefore(int pagesBlankBefore) {
        this.pagesBlankBefore = pagesBlankBefore;
    }

    public int getPagesBlankAfter() {
        return pagesBlankAfter;
    }

    public void setPagesBlankAfter(int pagesBlankAfter) {
        this.pagesBlankAfter = pagesBlankAfter;
    }
    //</editor-fold>

    public Column addColumn() {
        return addColumn(null);
    }

    public Column addColumn(String value) {
        if (rowsData.size() > 0) {
            throw new IllegalStateException("Após adicionar linhas, não é mais possível adicionar colunas");
        }

        Column c = new ColumnHeader(this, null).setValue(value);
        header.add((ColumnHeader) c);
        c.setOrder(header.size() - 1);
        return c;
    }

    public int getColumnsCount() {
        if (header.size() > 0) {
            return header.size();
        } else {
            return rowsData.get(0).getColumns().size();
        }
    }

    public Row addRow(Object... values) {
        Row row = addRow();
        row.addValues(values);
        return row;
    }

    public Row addRow() {
        /**
         * Antes de adicionar a primeira linha de dados, é adicionado as linhas
         * de operações (sum,MAX,...)
         */
        if (rowsData.size() <= 0) {
            for (int i = 0; i < Operation.values().length; i++) {
                Row operationRow = new Row(this);
                boolean hasOperation = false;
                while (hasNextHeader()) {
                    if (currentHeaderColumn.getOperations() != null && currentHeaderColumn.getOperations().length > i) {
                        hasOperation = true;
                        Operation operation = currentHeaderColumn.getOperations()[i];
                        switch (operation) {
                            case SUM:
                                operationRow.getColumns().add(new ColumnSum(this, operationRow, currentHeaderColumn));
                                break;
                            case COUNT:
                                operationRow.getColumns().add(new ColumnCount(this, operationRow, currentHeaderColumn));
                                break;
                            case HIGHEST:
                                operationRow.getColumns().add(new ColumnMax(this, operationRow, currentHeaderColumn));
                                break;
                            case LOWEST:
                                operationRow.getColumns().add(new ColumnMin(this, operationRow, currentHeaderColumn));
                                break;
                            case AVERAGE:
                                operationRow.getColumns().add(new ColumnAverage(this, operationRow, currentHeaderColumn));
                                break;
                            case LABEL_SUM:
                                operationRow.getColumns().add(new ColumnLabel(this, operationRow, operation, currentHeaderColumn));
                                break;
                            case LABEL_COUNT:
                                operationRow.getColumns().add(new ColumnLabel(this, operationRow, operation, currentHeaderColumn));
                                break;
                            case LABEL_HIGHEST:
                                operationRow.getColumns().add(new ColumnLabel(this, operationRow, operation, currentHeaderColumn));
                                break;
                            case LABEL_LOWEST:
                                operationRow.getColumns().add(new ColumnLabel(this, operationRow, operation, currentHeaderColumn));
                                break;
                            case LABEL_AVERAGE:
                                operationRow.getColumns().add(new ColumnLabel(this, operationRow, operation, currentHeaderColumn));
                                break;
                            default:
                                operationRow.getColumns().add(new Column(this, operationRow, currentHeaderColumn));
                                break;
                        }
                    } else {
                        operationRow.getColumns().add(new Column(this, operationRow, currentHeaderColumn));
                    }
                }
                if (hasOperation) {
                    rowsData.add(operationRow);
                    rowsOperation.add(operationRow);
                }
            }
        }

        currentRow = new Row(this);
        rowsData.add(rowsData.size() - rowsOperation.size(), currentRow);
        currentRow.getFont().setParent(this.font);
        currentRow.getDecorator().setParent(this.decorator);

        return currentRow;
    }

    public Column addValue() {
        return addValue(null);
    }

    public Column addValue(Object value) {
        if (currentRow == null) {
            addRow();
        }

        if (header.size() > 0 && currentRow.getColumns().size() == header.size()) {
            throw new IndexOutOfBoundsException("Quantidade máxima de colunas (" + header.size() + ") atingido");
        }

        Column column = new Column(this, currentRow, null).setValue(value);
        currentRow.getColumns().add(column);

        /**
         * Se a grid tem headers, a coluna herda as propriedades
         */
        if (header.size() > 0) {
            ColumnHeader headerColumn = header.get(currentRow.getColumns().size() - 1);
            column.setHeaderColumn(headerColumn);
            headerColumn.applyOperations(column.getValue());
        }

        if (value != null) {
            Class clazz = Util.getClass(value);
            if (column.gethAlign() == null) {
                if (Util.isNumber(clazz)) {
                    column.sethAlignRight();
                } else if (Util.isBoolean(clazz) || Util.isDate(clazz)) {
                    column.sethAlignCenter();
                } else {
                    column.sethAlignLeft();
                }
            }
        }

        return column;
    }

    /**
     * Cursor para acessar as linhas da grid. Depois de acessar a última linha,
     * retorna o cursor para o início
     *
     * @return retorna true e posiciona na próxima linha se ainda existir
     * linhas. retorna false e reposiciona para o início se não existir mais
     * linhas
     */
    public boolean hasNextRow() {
        if (rowIndex < rowsData.size() - 1) {
            rowIndex++;
            currentRow = rowsData.get(rowIndex);
            columnIndex = -1;
            return true;
        } else {
            rowIndex = -1;
            return false;
        }
    }

    /**
     * Cursor para acessar as colunas de uma linha. Ao atingir a última coluna,
     * o cursos é reposicionado para o início.
     *
     * @return retorna true e posiciona na próxima coluna se existir. Retorna
     * false e reposiciona o cursor para a primeira coluna se for a última
     * coluna.
     */
    public boolean hasNextColumn() {
        if (columnIndex < currentRow.getColumns().size() - 1) {
            columnIndex++;
            currentColumn = currentRow.getColumns().get(columnIndex);
            return true;
        } else {
            columnIndex = -1;
            return false;
        }
    }

    /**
     * Cursor para acessar os headers da grid. Ao atingir a última header, o
     * cursos é reposicionado para o início.
     *
     * @return retorna true e posiciona na próxima header se existir. Retorna
     * false e reposiciona o cursor para a primeira header se for a última
     * coluna.
     */
    public boolean hasNextHeader() {
        if (headerIndex < header.size() - 1) {
            headerIndex++;
            currentHeaderColumn = header.get(headerIndex);
            return true;
        } else {
            headerIndex = -1;
            return false;
        }
    }

    public LayoutGrid addNewPage() {
        if (currentRow == null) {
            pagesBlankBefore++;
        } else {
            pagesBlankAfter++;
        }
        return this;
    }

}
