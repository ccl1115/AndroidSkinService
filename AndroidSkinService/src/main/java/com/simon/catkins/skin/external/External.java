package com.simon.catkins.skin.external;

import android.content.res.Resources;

/**
 * A external skin must has its own package name and resources.
 * @author Simon Yu
 */
public interface External {
    String getPackage();

    Resources getResources();
}
