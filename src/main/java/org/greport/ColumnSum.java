package org.greport;

import java.text.DecimalFormat;

/**
 *
 * @author marcius.brandao
 */
public class ColumnSum extends Column {

    public ColumnSum(LayoutGrid grid, Row row, ColumnHeader headerColumn) {
        super(grid, row, headerColumn);
        super.sethAlign(HAlignment.RIGHT);
        super.setFontBold();
    }

    @Override
    public Object getValue() {
        return Util.formatDecimal(getHeaderColumn().getOperationSum());
    }

}
