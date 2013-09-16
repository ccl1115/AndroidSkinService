package com.simon.catkins.skin.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.simon.catkins.skin.SkinService;
import com.simon.catkins.skin.external.ExternalSkin;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getLayoutInflater().setFactory(SkinService.getInflatorFactory(this));
        super.onCreate(savedInstanceState);

        SkinService.addSkin(new ExternalSkin(this, "/sdcard/ExternalSkin-release.zip"));
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SkinService.applySkin(this, ExternalSkin.NAME);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
