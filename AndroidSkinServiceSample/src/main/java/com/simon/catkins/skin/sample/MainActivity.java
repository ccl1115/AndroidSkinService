package com.simon.catkins.skin.sample;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;

import com.simon.catkins.skin.ActivityWithSkin;
import com.simon.catkins.skin.SkinService;
import com.simon.catkins.skin.external.ExternalSkin;

public class MainActivity extends Activity {

    public static final String SKIN_PKG = "com.simon.catkins.skin.sample.externalskin";

    private ExternalSkin mExternalSkin;

    private ActivityWithSkin.Delegate mSkinDelegate;

    protected void onCreate(Bundle savedInstanceState) {
        mSkinDelegate = ActivityWithSkin.getDelegate(this);
        mSkinDelegate.onCreatePre();
        super.onCreate(savedInstanceState);

        mExternalSkin = new ExternalSkin(SKIN_PKG,
                "/sdcard/ExternalSkin-release.zip",
                getResources().getDisplayMetrics(),
                getResources().getConfiguration());

        SkinService.addSkin(mExternalSkin);

        setContentView(R.layout.activity_main);

        SkinService.applySkin(this, ExternalSkin.NAME);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSkinDelegate.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
