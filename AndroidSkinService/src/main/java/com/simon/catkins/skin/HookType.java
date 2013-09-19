package com.simon.catkins.skin;

/**
 * @author Simon Yu
*/
public class HookType {
    /**
     * Hook if it is a string
     */
    public static final int STRING = 0x1;

    /**
     * Hook if it's a color which starts with a '#' char
     */
    public static final int COLOR = 0x2;

    /**
     * Hook if it's a reference which starts with a '@' char
     */
    public static final int REFERENCE_ID = 0x4;

    /**
     * Hook if it's a dimension ends with 'dp', 'px', etc.
     */
    public static final int DIMENSION = 0x8;

    /**
     * Hook if it's a integer
     */
    public static final int INTEGER = 0x10;

    /**
     * Hook if it's a float
     */
    public static final int FLOAT = 0x20;

    /**
     * Hook if it's a boolean
     */
    public static final int BOOLEAN = 0x40;
}
