package com.simon.catkins.skin.external;

import android.util.TypedValue;
import android.view.View;

import com.simon.catkins.skin.hooks.BackgroundHook;

/**
 * @author Simon Yu
 */
public class ExtBackgroundHook extends BackgroundHook {
    private final static Apply APPLY = new Apply() {
        @Override
        public void to(View view, TypedValue value) {
            view.setBackgroundColor(ExtResources.getInstance()
                    .getResources()
                    .getColor(value.resourceId));
        }
    };

    @Override
    public Apply getApply() {
        return APPLY;
    }
}
