package org.greport;

import static org.greport.HAlignment.RIGHT;

/**
 *
 * @author marcius.brandao
 */
public class ColumnMin extends Column {

    public ColumnMin(LayoutGrid grid, Row row, ColumnHeader headerColumn) {
        super(grid, row, headerColumn);
        super.sethAlign(RIGHT);
        super.setFontBold();
    }

    @Override
    public Object getValue() {
        return getHeaderColumn().getOperationMin();
    }
}
