package com.swing.demo.layout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;

public class LayoutFactory2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(LayoutFactory2.class);

    private static final String DEFAULT = "default";
    private static final String FILL_DEFAULT_GROW = "fill:" + DEFAULT + ":grow";
    private static final String RIGHT_DEFAULT = "right:" + DEFAULT + "";
    private static final String RELATED_GAP_COL = FormSpecs.RELATED_GAP_COLSPEC.encode();
    private static final String RELATED_GAP_ROW = FormSpecs.RELATED_GAP_ROWSPEC.encode();

    private LayoutFactory2() {
    }

    /**
     * Creates a column specification for {@link FormLayout} where each "component" column is preceded by a column for
     * labels and separated by {@link FormSpecs#RELATED_GAP_COLSPEC}. Each label column defined as "right:default", each
     * component column is "default" unless specified to grow in which case it is "fill:default:grow".
     * 
     * @param columns number of columns
     * @param growColumns column indexes to grow
     * @return
     */
    public static String componentColumnSpec(int columns, int... growColumns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("columns must be > 0");
        }
        return defaultSpec(RIGHT_DEFAULT, columns, RELATED_GAP_COL, growColumns);
    }

    /**
     * Creates a column specification for {@link FormLayout} where each column is separated by
     * {@link FormSpecs#RELATED_GAP_COLSPEC}. Each column is "default" unless specified to grow in which case it is
     * "fill:default:grow".
     * 
     * @param columns number of columns
     * @param growColumns column indexes to grow
     * @return
     */
    public static String relatedColumnSpec(int columns, int... growColumns) {
        if (columns <= 0) {
            throw new IllegalArgumentException("columns must be > 0");
        }
        return defaultSpec(columns, RELATED_GAP_COL, growColumns);
    }

    /**
     * Creates a row specification for {@link FormLayout} where each row is separated by
     * {@link FormSpecs#RELATED_GAP_ROWSPEC}. Each row is "default" unless specified to grow in which case it is
     * "fill:default:grow".
     * 
     * @param rows number of rows
     * @param growRows column indexes to grow
     * @return
     */
    public static String relatedRowSpec(int rows, int... growRows) {
        if (rows <= 0) {
            throw new IllegalArgumentException("rows must be > 0");
        }
        return defaultSpec(rows, RELATED_GAP_ROW, growRows);
    }

    /**
     * Creates a row specification for {@link FormLayout} where each row is separated by
     * {@link FormSpecs#RELATED_GAP_ROWSPEC}. Each row is the value of {@code vAlign} prepended to "default" unless
     * specified to grow in which case it is "fill:default:grow".
     * 
     * @param rows number of rows
     * @param vAlign vertical alignment for rows (centered if not specified)
     * @param growRows column indexes to grow
     * @return
     */
    public static String relatedRowSpec(int rows, String vAlign, int... growRows) {
        if (rows <= 0) {
            throw new IllegalArgumentException("rows must be > 0");
        }
        String dSpec = vAlign == null || vAlign.isEmpty() ? DEFAULT : vAlign + ":" + DEFAULT;
        return defaultSpec(null, rows, dSpec, RELATED_GAP_ROW, growRows);
    }

    public static FormLayout defaultFormLayout(int columns, int rows) {
        return new FormLayout(relatedColumnSpec(columns), relatedRowSpec(rows));
    }

    /**
     * Creates a specification for {@link FormLayout} where "default" is specified the number of times defined by
     * {@code count} and each time it is separated by the gap. For indexes defined to grow "fill:default:grow" is used
     * in place of "default".
     * 
     * @param count number of default columns/rows
     * @param grow indexes to grow, NB. to match {@link FormLayout} index starts at 1 (not 0 like most other Java stuff)
     * @return
     */
    private static String defaultSpec(int count, String relatedGap, int... grow) {
        return defaultSpec(null, count, relatedGap, grow);
    }

    /**
     * Creates a specification for {@link FormLayout} where "default" is specified the number of times defined by
     * {@code count} and each time it is separated by the gap. For indexes defined to grow "fill:default:grow" is used
     * in place of "default".
     * 
     * @param customPre a custom specification to put before each default specification (with gap in between)
     * @param count number of default columns/rows
     * @param grow indexes to grow, NB. to match {@link FormLayout} index starts at 1 (not 0 like most other Java stuff)
     * @return
     */
    private static String defaultSpec(String customPre, int count, String relatedGap, int... grow) {
        return defaultSpec(customPre, count, DEFAULT, relatedGap, grow);
    }

    /**
     * Creates a specification for {@link FormLayout} where "default" is specified the number of times defined by
     * {@code count} and each time it is separated by the gap. For indexes defined to grow "fill:default:grow" is used
     * in place of "default".
     * 
     * @param customPre a custom specification to put before each default specification (with gap in between)
     * @param count number of default columns/rows
     * @param grow indexes to grow, NB. to match {@link FormLayout} index starts at 1 (not 0 like most other Java stuff)
     * @return
     */
    private static String defaultSpec(String customPre, int count, String defaultSpec, String relatedGap, int... grow) {
        if (count <= 0) {
            throw new IllegalArgumentException("count must be > 0");
        }
        StringBuilder spec = new StringBuilder();
        boolean grows = false;
        for (int i = 1; i <= count; i++) {
            grows = false;
            if (i > 1) {
                spec.append(", " + relatedGap + ", ");
            }
            if (customPre != null && customPre.trim().length() > 0) {
                spec.append(customPre + ", " + relatedGap + ", ");
            }
            if (grow != null) {
                for (int j : grow) {
                    if (j == i) {
                        grows = true;
                        break;
                    }
                }
            }
            spec.append(grows ? FILL_DEFAULT_GROW : defaultSpec);
        }
        LOGGER.debug(spec.toString());
        return spec.toString();
    }

}
