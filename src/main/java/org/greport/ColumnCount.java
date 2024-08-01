package org.greport;

public class ColumnCount extends Column {

    public ColumnCount(LayoutGrid grid, Row row, ColumnHeader headerColumn) {
        super(grid, row, headerColumn);
        super.sethAlign(HAlignment.CENTER);
        super.setFontBold();
    }

    @Override
    public Object getValue() {
        return "(" + getHeaderColumn().getOperationCount().toString() + ")";
    }
}
