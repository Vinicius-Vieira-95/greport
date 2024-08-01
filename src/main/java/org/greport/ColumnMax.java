package org.greport;

/**
 *
 * @author marcius.brandao
 */
public class ColumnMax extends Column {

    public ColumnMax(LayoutGrid grid, Row row, ColumnHeader headerColumn) {
        super(grid, row, headerColumn);        
        super.sethAlign(HAlignment.RIGHT);
        super.setFontBold();
    }

    @Override
    public Object getValue() {
        return getHeaderColumn().getOperationMax();
    }
}
