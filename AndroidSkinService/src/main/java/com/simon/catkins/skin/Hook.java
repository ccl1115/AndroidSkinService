package com.simon.catkins.skin;

import android.util.TypedValue;
import android.view.View;

/**
 * 指向Xml文件中的控件的钩子
 * @author yulu02
*/
public interface Hook {

    int hookType();

    String hookName();

    @SuppressWarnings("SameReturnValue")
    boolean shouldHook(View view, TypedValue value);

    Apply getApply();

    public interface Apply {
        void to(View view, TypedValue value);
    }
}
