package org.greport;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Marcius
 */
public enum Operation {

    NOTHING,
    AVERAGE,
    COUNT,
    HIGHEST,
    LOWEST,
    SUM,
    LABEL_AVERAGE("Média"),
    LABEL_COUNT,
    LABEL_HIGHEST("Max."),
    LABEL_LOWEST("Min."),
    LABEL_SUM("Soma");

    private String label;    

    private Operation() {
        label = "";
    }

    private Operation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Operation setLabel(String label) {
        this.label = label;
        return this;
    }

}
