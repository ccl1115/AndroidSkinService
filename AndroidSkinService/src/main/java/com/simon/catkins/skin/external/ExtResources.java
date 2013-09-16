package com.simon.catkins.skin.external;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This resources class can load external zipped or not zipped(directory) resources.
 *
 * Call {@link #setExternalResourcesPath} before you try to load any resources,
 * otherwise you will get nothing.
 *
 * @author Simon Yu
 *
 * @see android.content.res.AssetManager
 * @see android.content.pm.PackageManager
 * @see android.content.res.Resources
 */
class ExtResources {
    private static final String TAG = "ExtResources";

    private static ExtResources mExtResources;

    private AssetManager mAssetManager;
    private Resources mRes;
    private Context mContext;

    private ExtResources(Context context) {
        mContext = context.getApplicationContext();
    }

    public synchronized static ExtResources getInstance(Context context) {
        if (mExtResources == null)  {
            mExtResources = new ExtResources(context);
        }
        return mExtResources;
    }


    /**
     * Use reflection to create a default AssetManager
     * @return the system asset manager
     */
    private static AssetManager getSystemAssetManager() {
        Class<AssetManager> clazz = AssetManager.class;
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /**
     * Use reflection to add resources path to asset manager.
     *
     * @param file the zip file or directory
     */
    private int addAssetPath(String file) {
        Class<AssetManager> clazz = AssetManager.class;
        try {
            Method m = clazz.getDeclaredMethod("addAssetPath", String.class);
            return (Integer) m.invoke(mAssetManager, file);
        } catch (NoSuchMethodException e) {
            Log.d(TAG, "NoSuchMethodException");
        } catch (InvocationTargetException e) {
            Log.d(TAG, "InvocationTargetException");
        } catch (IllegalAccessException e) {
            Log.d(TAG, "IllegalAccessException");
        }
        return 0;
    }

    /**
     * the resource class will contain all resources in the target zipped file.
     *
     * @return the resources
     */
    public Resources getResources() {
        return mRes;
    }

    public void setExternalResourcesPath(String file) {
        mAssetManager = getSystemAssetManager();
        int cookie = addAssetPath(file);
        if (cookie == 0) {
            Log.w(TAG, "external resources not found");
        }
        final Resources resources = mContext.getResources();
        mRes = new Resources(mAssetManager, resources.getDisplayMetrics(),
                resources.getConfiguration());
    }
}
