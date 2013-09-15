package com.simon.catkins.skin.impl;

import com.simon.catkins.skin.Skin;
import com.simon.catkins.skin.hooks.BackgroundHook;
import com.simon.catkins.skin.hooks.TextColorHook;
import com.simon.catkins.skin.hooks.TextHook;
import com.simon.catkins.skin.hooks.VisibilityHook;

/**
 * @author Simon Yu
 */
public abstract class BaseSkin extends Skin {

    BaseSkin() {
        put("background", new BackgroundHook());
        put("textColor", new TextColorHook());
        put("text", new TextHook());
        put("visibility", new VisibilityHook());
    }

}
