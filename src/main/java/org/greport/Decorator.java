package org.greport;

/**
 *
 * @author marcius.brandao
 */
public class Decorator {

    private Decorator parent;

    private Borders borderTop;
    private Borders borderRight;
    private Borders borderBottom;
    private Borders borderLeft;

    private Float marginTop;
    private Float marginLeft;
    private Float marginBottom;
    private Float marginRight;

    private Float paddingTop;
    private Float paddingLeft;
    private Float paddingBottom;
    private Float paddingRight;

    public Decorator getParent() {
        return parent;
    }

    public void setParent(Decorator parent) {
        this.parent = parent;
    }

    public void setBorder(Borders border) {
        borderTop = border;
        borderRight = border;
        borderBottom = border;
        borderLeft = border;
    }

    public Borders getBorderTop() {
        if (this.borderTop == null && parent != null) {
            return parent.getBorderTop();
        }
        return borderTop;
    }

    public void setBorderTop(Borders borderTop) {
        this.borderTop = borderTop;
    }

    public Borders getBorderRight() {
        if (this.borderRight == null && parent != null) {
            return parent.getBorderRight();
        }
        return borderRight;
    }

    public void setBorderRight(Borders borderRight) {
        this.borderRight = borderRight;
    }

    public Borders getBorderBottom() {
        if (borderBottom == null && parent != null) {
            return parent.getBorderBottom();
        }
        return borderBottom;
    }

    public void setBorderBottom(Borders borderBottom) {
        this.borderBottom = borderBottom;
    }

    public Borders getBorderLeft() {
        if (borderLeft == null && parent != null) {
            return parent.getBorderLeft();
        }
        return borderLeft;
    }

    public void setBorderLeft(Borders borderLeft) {
        this.borderLeft = borderLeft;
    }

    public void setMargin(Float border) {
        marginTop = border;
        marginRight = border;
        marginBottom = border;
        marginLeft = border;
    }
 
    public void setMargins(float top, float right, float bottom, float left) {
        marginTop = top;        
        marginRight = right;
        marginBottom = bottom;
        marginLeft = left;        
    }

    public Float getMarginTop() {
        if (marginTop == null && parent != null) {
            return parent.getMarginTop();
        }
        return marginTop;
    }

    public void setMarginTop(Float marginTop) {
        this.marginTop = marginTop;
    }

    public Float getMarginLeft() {
        if (marginLeft == null && parent != null) {
            return parent.getMarginLeft();
        }
        return marginLeft;
    }

    public void setMarginLeft(Float marginLeft) {
        this.marginLeft = marginLeft;
    }

    public Float getMarginBottom() {
        if (marginBottom == null && parent != null) {
            return parent.getMarginBottom();
        }
        return marginBottom;
    }

    public void setMarginBottom(Float marginBottom) {
        this.marginBottom = marginBottom;
    }

    public Float getMarginRight() {
        if (marginRight == null && parent != null) {
            return parent.getMarginRight();
        }
        return marginRight;
    }

    public void setMarginRight(Float marginRight) {
        this.marginRight = marginRight;
    }

    public void setPaddings(Float padding) {
        paddingTop = padding;
        paddingRight = padding;
        paddingBottom = padding;
        paddingLeft = padding;
    }
    
    public void setPaddings(float top, float right, float bottom, float left) {
        paddingTop = top;        
        paddingRight = right;
        paddingBottom = bottom;
        paddingLeft = left;        
    }

    public Float getPaddingTop() {
        if (paddingTop == null && parent != null) {
            return parent.getPaddingTop();
        }
        return paddingTop;
    }

    public void setPaddingTop(Float paddingTop) {
        this.paddingTop = paddingTop;
    }

    public Float getPaddingLeft() {
        if (paddingLeft == null && parent != null) {
            return parent.getPaddingLeft();
        }
        return paddingLeft;
    }

    public void setPaddingLeft(Float paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public Float getPaddingBottom() {
        if (paddingBottom == null && parent != null) {
            return parent.getPaddingBottom();
        }
        return paddingBottom;
    }

    public void setPaddingBottom(Float paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public Float getPaddingRight() {
        if (paddingRight == null && parent != null) {
            return parent.getPaddingRight();
        }
        return paddingRight;
    }

    public void setPaddingRight(Float paddingRight) {
        this.paddingRight = paddingRight;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        if (getBorderTop() != null || getBorderRight() != null || getBorderBottom() != null || getBorderLeft() != null) {
            s.append("\n Borders:");
            if (getBorderTop() != null) {
                s.append("\n borderTop=").append(borderTop != null ? borderTop : "->" + getBorderTop());
            }
            if (getBorderRight() != null) {
                s.append("\n borderRigth=").append(borderRight != null ? borderRight : "->" + getBorderRight());
            }
            if (getBorderBottom() != null) {
                s.append("\n borderBottom=").append(borderBottom != null ? borderBottom : "->" + getBorderBottom());
            }
            if (getBorderLeft() != null) {
                s.append("\n borderLeft=").append(borderLeft != null ? borderLeft : "->" + getBorderLeft());
            }
        }

        if (getMarginTop() != null || getMarginRight() != null || getMarginBottom() != null || getMarginLeft() != null) {
            s.append("\n Margins:");
            if (getMarginTop() != null) {
                s.append("\n marginTop=").append(marginTop != null ? marginTop : "->" + getMarginTop());
            }
            if (getMarginRight() != null) {
                s.append("\n marginRigth=").append(marginRight != null ? marginRight : "->" + getMarginRight());
            }
            if (getMarginBottom() != null) {
                s.append("\n marginBottom=").append(marginBottom != null ? marginBottom : "->" + getMarginBottom());
            }
            if (getMarginLeft() != null) {
                s.append("\n marginLeft=").append(marginLeft != null ? marginLeft : "->" + getMarginLeft());
            }
        }

        if (getPaddingTop() != null || getPaddingRight() != null || getPaddingBottom() != null || getPaddingLeft() != null) {
            s.append("\n Paddings:");
            if (getPaddingTop() != null) {
                s.append("\n paddingTop=").append(paddingTop != null ? paddingTop : "->" + getPaddingTop());
            }
            if (getPaddingRight() != null) {
                s.append("\n paddingRigth=").append(paddingRight != null ? paddingRight : "->" + getPaddingRight());
            }
            if (getPaddingBottom() != null) {
                s.append("\n paddingBottom=").append(paddingBottom != null ? paddingBottom : "->" + getPaddingBottom());
            }
            if (getPaddingLeft() != null) {
                s.append("\n paddingLeft=").append(paddingLeft != null ? paddingLeft : "->" + getPaddingLeft());
            }
        }

        return s.toString();
    }

}
