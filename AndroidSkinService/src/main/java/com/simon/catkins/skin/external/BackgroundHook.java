package com.simon.catkins.skin.external;

import android.util.TypedValue;
import android.view.View;

import com.simon.catkins.skin.Hook;
import com.simon.catkins.skin.HookType;

/**
 * @author Simon Yu
 */
public class BackgroundHook implements Hook {
    private final static Apply APPLY = new Apply() {
        @Override
        public void to(View view, TypedValue value) {
            view.setBackgroundColor(ExtResources.getInstance()
                    .getResources()
                    .getColor(value.resourceId));
        }
    };

    @Override
    public int hookType() {
        return HookType.REFERENCE_ID;
    }

    @Override
    public String hookName() {
        return "background";
    }

    @Override
    public boolean shouldHook(View view, TypedValue value) {
        return true;
    }

    @Override
    public Apply getApply() {
        return APPLY;
    }
}
