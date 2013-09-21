package com.simon.catkins.skin;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

/**
 * When iterate a xml node's attributes, a hook decides whether
 * to bind the attribute to the view or not.
 * @author yulu02
*/
public interface Hook {

    /**
     * @return The resource type to be hook
     * @see HookType
     */
    int hookType();

    /**
     * @return the attribute name to be hook
     */
    String hookName();

    /**
     * When type and name matches and parses correctly, confirm
     * it should be bind to the view.
     * @param view the view to bind to.
     * @param value the value to be bound
     * @return bind if return true
     */
    boolean shouldHook(View view, TypedValue value);

    /**
     * Get the apply.
     * @return the apply
     */
    Apply getApply();

    /**
     * Apply is a method to be call when apply a skin.
     * It contains the procedure of changing the view to
     * the new skin using the bound TypedValue.
     */
    public interface Apply {
        void to(View view, TypedValue value, Resources res);
    }
}
