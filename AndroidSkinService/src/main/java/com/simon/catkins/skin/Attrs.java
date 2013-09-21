package com.simon.catkins.skin;

/**
 * These xml attributes are not parsed by Android's parser, so they aren't defined
 * in the attrs.xml file.
 *
 * They are parsed by the SkinInflaterFactory.
 *
 * @author Simon Yu
 */
class Attrs {
    static final String NAMESPACE = "http://schemas.android.com/android/skin";

    /**
     * Whether skip this xml node or not to parse its skin information.
     */
    static final String ATTR_SKIP = "skip";

    /**
     * Force this view object to always use a skin.
     */
    static final String ATTR_FORCE_SKIN = "forceSkin";
}
