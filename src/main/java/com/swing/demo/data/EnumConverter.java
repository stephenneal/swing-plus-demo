package com.swing.demo.data;

import org.apache.commons.lang.WordUtils;

public class EnumConverter {

    private EnumConverter() {
    }

    /**
     * Get all values as words in title case.
     * 
     * @return all values as words in title case.
     */
    public static String[] wordsTitleCase(Enum<?>... values) {
        String[] titleCaseValues = new String[values.length];
        int i = 0;
        for (Enum<?> e : values) {
            titleCaseValues[i++] = WordUtils.capitalizeFully(e.name(), new char[] { '_' }).replace("_", " ");
        }
        return titleCaseValues;
    }

    /**
     * Get all values with name converted to {@link String}.
     * 
     * @return all values with name converted to {@link String}.
     */
    public static String[] nameToString(Enum<?>... values) {
        String[] titleCaseValues = new String[values.length];
        int i = 0;
        for (Enum<?> e : values) {
            titleCaseValues[i++] = e.name();
        }
        return titleCaseValues;
    }

}
