package com.simon.catkins.skin;

import android.util.Log;

/**
 * An internal logger
 * <p/>
 *
 * @author Simon Yu
 */
class Loot {

    static void logApply(String msg) {
        if (BuildConfig.DEBUG) Log.d("skin.apply", msg);
    }

    static void logInflate(String msg) {
        if (BuildConfig.DEBUG) Log.d("skin.inflate", msg);

    }

    static void logParse(String msg) {
        if (BuildConfig.DEBUG) Log.d("skin.parse", msg);
    }
}
