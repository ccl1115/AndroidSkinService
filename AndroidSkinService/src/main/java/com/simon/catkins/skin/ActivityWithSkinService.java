package com.simon.catkins.skin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

/**
 * @author Simon Yu
 */
public class ActivityWithSkinService extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater layoutInflater
                = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        layoutInflater.setFactory(SkinService.getInflatorFactory(this));
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SkinService.applySkin(this);
    }
}
