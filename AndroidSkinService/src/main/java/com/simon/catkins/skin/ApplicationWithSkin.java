package com.simon.catkins.skin;

import android.app.Application;

/**
 * @author bb.simon.yu@gmail.com
 */
public class ApplicationWithSkin extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinService.init(this);
    }
}
