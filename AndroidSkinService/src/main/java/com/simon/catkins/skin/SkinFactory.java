package com.simon.catkins.skin;

import com.simon.catkins.skin.impl.DefaultSkin;
import com.simon.catkins.skin.impl.NightSkin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon Yu
 */
final class SkinFactory {

    private static SkinFactory sFactory;

    private Map<String, Skin> mSkins;

    private SkinFactory() {
        mSkins = new HashMap<String, Skin>();
        mSkins.put(DefaultSkin.NAME, new DefaultSkin());
        mSkins.put(NightSkin.NAME, new NightSkin());
    }

    public synchronized static SkinFactory getFactory() {
        if (sFactory == null) {
            sFactory = new SkinFactory();
        }
        return sFactory;
    }

    public void register(Skin skin) {
        if (mSkins.containsKey(skin.getName())) {
            return;
        }
        mSkins.put(skin.getName(), skin);
    }

    public void unregister(String name) {
        mSkins.remove(name);
    }

    public Skin get(String name) {
        return mSkins.get(name);
    }

    public Collection<Skin> all() {
        return mSkins.values();
    }
}
