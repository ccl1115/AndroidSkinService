package com.simon.catkins.skin.external;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.simon.catkins.skin.Skin;
import com.simon.catkins.skin.TypedValueParser;
import com.simon.catkins.skin.TypedValueParserImpl;

/**
 * @author Simon Yu
 */
public final class ExternalSkin extends Skin implements External {
    public static final String NAME = "external";

    private final String mPkg;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getNamespace() {
        return "http://schemas.android.com/android/skin/external";
    }

    @Override
    public String getPackage() {
        return mPkg;
    }

    @Override
    public Resources getResources() {
        return ExtResources.getInstance().getResources();
    }

    @Override
    public TypedValueParser getParser() {
        return null;
    }

    public ExternalSkin(String pkg, String path, DisplayMetrics dm, Configuration config) {
        mPkg = pkg;
        ExtResources.getInstance().setExternalResources(path, dm, config);
        put("background", new ExtBackgroundHook());
    }

}
