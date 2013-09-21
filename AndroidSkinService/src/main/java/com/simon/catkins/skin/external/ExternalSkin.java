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

    private TypedValueParser mParser = new Parser();

    private String mPkg;

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
        return mParser;
    }

    public ExternalSkin(String pkg, String path, DisplayMetrics dm, Configuration config) {
        setExternalPath(pkg, path, dm, config);
        put("background", new ExtBackgroundHook());
    }

    public void setExternalPath(String pkg, String path, DisplayMetrics dm, Configuration config) {
        mPkg = pkg;
        ExtResources.getInstance().setExternalResources(path, dm, config);
    }

    public void updateConfiguration(String pkg, DisplayMetrics dm, Configuration config) {
        mPkg = pkg;
        ExtResources.getInstance().updateConfiguration(dm, config);
    }

    private class Parser extends TypedValueParserImpl {
        @Override
        public TypedValue parseReference(String ref, Resources res, String pkg) {
            TypedValue tv = super.parseReference(ref, res, pkg);
            if (tv != null) {
                // Need the literal string to re-parser a resource when
                // the external path changed.
                tv.string = ref;
            }
            return tv;
        }
    }
}
