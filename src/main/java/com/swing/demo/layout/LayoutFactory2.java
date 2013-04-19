package com.swing.demo.layout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;

public class LayoutFactory2 {

    private LayoutFactory2() {
    }

    /**
     * Creates a column specification for {@link FormLayout} where each column is separated by
     * {@link FormSpecs#RELATED_GAP_COLSPEC}.
     * 
     * @param columns
     * @return
     */
    public static String relatedColumnSpec(int columns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("columns must be > 0");
        }
        StringBuilder spec = new StringBuilder();
        String relatedGap = FormSpecs.RELATED_GAP_COLSPEC.encode();
        String unrelatedGap = FormSpecs.UNRELATED_GAP_COLSPEC.encode();
        for (int i = 0; i < columns; i++) {
            if (i > 0) {
                spec.append(", " + unrelatedGap + ", ");
            }
            spec.append("right:pref, ");
            spec.append(relatedGap);
            spec.append(", fill:default:grow");
        }
        return spec.toString();
    }

    /**
     * Creates a row specification for {@link FormLayout} where each row is separated by
     * {@link FormSpecs#RELATED_GAP_ROWSPEC}.
     * 
     * @param columns
     * @return
     */
    public static String relatedRowSpec(int rows) {
        if (rows <= 0) {
            throw new IllegalArgumentException("columns must be > 0");
        }
        StringBuilder spec = new StringBuilder();
        String gap = FormSpecs.RELATED_GAP_COLSPEC.encode();
        for (int i = 0; i < rows; i++) {
            if (i > 0) {
                spec.append(", " + gap + ", ");
            }
            spec.append("default");
        }
        return spec.toString();
    }

    public static FormLayout defaultFormLayout(int columns, int rows) {
        if (columns <= 0) {
            throw new IllegalArgumentException("columns must be > 0");
        }
        if (rows <= 0) {
            throw new IllegalArgumentException("rows must be > 0");
        }
        return new FormLayout(relatedColumnSpec(columns), relatedRowSpec(rows));
    }

}
