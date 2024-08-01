package org.greport;

import java.awt.Color;

/**
 *
 * @author marcius.brandao
 */
public class Font {

    public static final String COURIER = "Courier";
    public static final String COURIER_BOLD = "Courier-Bold";
    public static final String COURIER_OBLIQUE = "Courier-Oblique";
    public static final String COURIER_BOLDOBLIQUE = "Courier-BoldOblique";
    public static final String HELVETICA = "Helvetica";
    public static final String HELVETICA_BOLD = "Helvetica-Bold";
    public static final String HELVETICA_OBLIQUE = "Helvetica-Oblique";
    public static final String HELVETICA_BOLDOBLIQUE = "Helvetica-BoldOblique";
    public static final String SYMBOL = "Symbol";
    public static final String TIMES_ROMAN = "Times-Roman";
    public static final String TIMES_BOLD = "Times-Bold";
    public static final String TIMES_ITALIC = "Times-Italic";
    public static final String TIMES_BOLDITALIC = "Times-BoldItalic";
    public static final String ZAPFDINGBATS = "ZapfDingbats";

    private Font parent;
    private String name;
    private Integer size;
    private Color color;
    private Color backgroundColor;
    private Boolean bold;
    private Boolean italic;
    private Boolean underline;

    private HAlignment hAlignment;

    public Font() {
    }

    public Font(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    public Font getParent() {
        return parent;
    }

    public void setParent(Font parent) {
        this.parent = parent;
    }

    public String getName() {
        if (name == null && parent != null) {
            return parent.getName();
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        if (size == null && parent != null) {
            return parent.getSize();
        }
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getBold() {
        if (bold == null && parent != null) {
            return parent.getBold();
        }
        return bold;
    }

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public Boolean getItalic() {
        if (italic == null && parent != null) {
            return parent.getItalic();
        }
        return italic;
    }

    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

    public Boolean getUnderline() {
        if (underline == null && parent != null) {
            return parent.getUnderline();
        }
        return underline;
    }

    public void setUnderline(Boolean underline) {
        this.underline = underline;
    }

    public Color getColor() {
        if (color == null && parent != null) {
            return parent.getColor();
        }
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getBackgroundColor() {
        if (backgroundColor == null && parent != null) {
            return parent.getBackgroundColor();
        }
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public HAlignment gethAlignment() {
        if (hAlignment == null && parent != null) {
            return parent.gethAlignment();
        }

        return hAlignment;
    }

    public void sethAlignment(HAlignment hAlignment) {
        this.hAlignment = hAlignment;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Font {");
        if (getName() != null) {
            s.append("\n name=").append(name != null ? name : "->" + getName());
        }
        if (getSize() != null) {
            s.append("\n size=").append(size != null ? size : "->" + getSize());
        }
        if (getBold() != null) {
            s.append("\n bold=").append(bold != null ? bold : "->" + getBold());
        }
        if (getItalic() != null) {
            s.append("\n italic=").append(italic != null ? italic : "->" + getItalic());
        }
        if (getUnderline() != null) {
            s.append("\n underline=").append(underline != null ? underline : "->" + getUnderline());
        }
        if (getColor() != null) {
            s.append("\n color=").append(color != null ? color : "->" + getColor());
        }
        if (getBackgroundColor() != null) {
            s.append("\n backgroundColor=").append(backgroundColor != null ? backgroundColor : "->" + getBackgroundColor());
        }
        s.append("}");
        return s.toString();
    }

}
