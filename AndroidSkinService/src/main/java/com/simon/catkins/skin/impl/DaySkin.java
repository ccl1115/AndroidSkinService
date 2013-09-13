package com.simon.catkins.skin.impl;


/**
 * @author Simon Yu
 */
public class DaySkin extends BaseHookSet {

    public static final String NAME = "day";

    @Override
    public String getPrefix() {
        return NAME;
    }

    @Override
    public String getNamespace() {
        return "http://schemas.android.com/android/skin/day";
    }
}
