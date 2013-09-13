package com.simon.catkins.skin.impl;

import com.simon.catkins.skin.HookSet;
import com.simon.catkins.skin.hooks.BackgroundHook;
import com.simon.catkins.skin.hooks.TextColorHook;
import com.simon.catkins.skin.hooks.TextHook;
import com.simon.catkins.skin.hooks.VisibilityHook;

/**
 * @author Simon Yu
 */
abstract class BaseHookSet extends HookSet {

    BaseHookSet() {
        put("background", new BackgroundHook());
        put("textColor", new TextColorHook());
        put("text", new TextHook());
        put("visibility", new VisibilityHook());
    }

}
