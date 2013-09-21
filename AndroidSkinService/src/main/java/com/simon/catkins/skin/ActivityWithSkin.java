package com.simon.catkins.skin;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Any activity extends this activity will have the skin service affected.
 *
 * @author Simon Yu
 */
public class ActivityWithSkin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater layoutInflater
                = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        layoutInflater.setFactory(SkinService.getInflaterFactory());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SkinService.applySkin(this);
    }
}
