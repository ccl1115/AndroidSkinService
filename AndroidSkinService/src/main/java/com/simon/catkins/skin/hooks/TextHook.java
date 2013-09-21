package com.simon.catkins.skin.hooks;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.simon.catkins.skin.Hook;

/**
 * @author Simon Yu
 */
public class TextHook implements Hook {

    private static final Apply APPLY = new Apply() {
        @Override
        public void to(View view, TypedValue value, Resources res) {
            if (!(view instanceof TextView)) { return; }

            TextView tv = (TextView) view;
            switch (value.type) {
                case TypedValue.TYPE_REFERENCE:
                    tv.setText(res.getText(value.resourceId));
                    break;
                case TypedValue.TYPE_STRING:
                    tv.setText(value.string);
                    break;
            }
        }
    };

    @Override
    public int hookType() {
        // computed from HookType.REFERENCE_ID | HookType.STRING;
        return 5;
    }

    @Override
    public String hookName() {
        return "text";
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
