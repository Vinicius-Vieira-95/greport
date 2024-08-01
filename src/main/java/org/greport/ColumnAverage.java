package org.greport;

/**
 *
 * @author marcius.brandao
 */
public class ColumnAverage extends Column {

    public ColumnAverage(LayoutGrid grid, Row row, ColumnHeader headerColumn) {
        super(grid, row, headerColumn);
        super.setHeaderColumn(headerColumn);
        super.sethAlign(HAlignment.RIGHT);
        super.setFontBold();
    }

    @Override
    public Object getValue() {
        return getHeaderColumn().getOperationAverage();
    }
}
