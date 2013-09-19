package com.simon.catkins.skin;

import android.app.Application;
import android.view.LayoutInflater;

/**
 * @author Simon Yu
 */
public class ApplicationWithSkinService extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LayoutInflater layoutInflater
                = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        layoutInflater.setFactory(SkinService.getInflatorFactory(this));
    }
}
