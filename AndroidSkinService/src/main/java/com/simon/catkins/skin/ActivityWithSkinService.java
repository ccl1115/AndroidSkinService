package com.simon.catkins.skin;

import android.app.Activity;

/**
 * @author Simon Yu
 */
public class ActivityWithSkinService extends Activity {

    @Override
    protected void onResume() {
        super.onResume();
        SkinService.applySkin(this);
    }
}
