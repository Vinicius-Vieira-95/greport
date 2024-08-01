package org.greport;

import static org.greport.HAlignment.CENTER;

/**
 *
 * @author marcius.brandao
 */
public class ColumnLabel extends Column {

    private String label;

    public ColumnLabel(LayoutGrid grid, Row row, Operation operation, ColumnHeader headerColumn) {
        super(grid, row, headerColumn);
        label = operation.getLabel();
        super.sethAlign(CENTER);
        super.setFontBold();
    }

    @Override
    public Object getValue() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
