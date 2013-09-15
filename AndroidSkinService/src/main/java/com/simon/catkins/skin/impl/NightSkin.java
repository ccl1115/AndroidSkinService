package com.simon.catkins.skin.impl;

/**
 * @author Simon Yu
 */
public class NightSkin extends BaseSkin {

    public static final String NAME = "night";

    @Override
    public String getPrefix() {
        return NAME;
    }

    @Override
    public String getNamespace() {
        return "http://schemas.android.com/android/skin/night";
    }
}
