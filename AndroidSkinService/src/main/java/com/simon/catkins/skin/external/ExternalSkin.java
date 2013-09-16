package com.simon.catkins.skin.external;

import android.content.Context;
import android.content.res.Resources;

import com.simon.catkins.skin.Skin;

/**
 * @author Simon Yu
 */
public final class ExternalSkin extends Skin {
    public static final String NAME = "external";

    private Context mContext;

    @Override
    public String getPrefix() {
        return NAME;
    }

    @Override
    public String getNamespace() {
        return "http://schemas.android.com/android/skin/external";
    }

    @Override
    public Resources getResources() {
        return ExtResources.getInstance(mContext).getResources();
    }

    public ExternalSkin(Context context, String path) {
        mContext = context;
        setExternalPath(path);
        put("background", new BackgroundHook());
    }

    public void setExternalPath(String path) {
        ExtResources.getInstance(mContext).setExternalResourcesPath(path);
    }
}
