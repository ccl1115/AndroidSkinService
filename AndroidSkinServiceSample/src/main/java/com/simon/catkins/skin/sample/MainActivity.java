package com.simon.catkins.skin.sample;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;

import com.simon.catkins.skin.SkinService;
import com.simon.catkins.skin.external.ExternalSkin;

public class MainActivity extends Activity {

    private ExternalSkin mExternalSkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getLayoutInflater().setFactory(SkinService.getInflatorFactory(this));
        super.onCreate(savedInstanceState);

        mExternalSkin = new ExternalSkin("/sdcard/ExternalSkin-release.zip",
                getResources().getDisplayMetrics(),
                getResources().getConfiguration());

        SkinService.addSkin(mExternalSkin);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SkinService.applySkin(this, ExternalSkin.NAME);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mExternalSkin.updateConfiguration(getResources().getDisplayMetrics(), newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
