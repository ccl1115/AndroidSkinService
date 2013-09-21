package com.simon.catkins.skin;

import android.content.res.Resources;
import android.util.TypedValue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Define a skin interface
 *
 * @author yulu02
 */
public abstract class Skin implements Map<String, Hook> {

    private final Map<String, Hook> mHooks = new HashMap<String, Hook>();

    /**
     * The name of the skin. use to retrieve the skin object from
     * the skin factory. or the prefix of the attribute in xml.
     *
     * @return the name
     */
    public abstract String getName();

    /**
     * The namespace is used in the xml.
     * @return the xmlns namespace
     */
    public abstract String getNamespace();

    /**
     * Provide your custom TypedValueParser. Return null if want
     * to use the default one.
     * @return A custom Parser.
     */
    public abstract TypedValueParser getParser();

    public abstract Resources getResources();

    @Override
    public void clear() {
        mHooks.clear();
    }

    @Override
    public boolean containsKey(Object o) {
        return mHooks.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return mHooks.containsValue(o);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Set<Entry<String, Hook>> entrySet() {
        return mHooks.entrySet();
    }

    @Override
    public Hook get(Object o) {
        return mHooks.get(o);
    }

    @Override
    public boolean isEmpty() {
        return mHooks.isEmpty();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Set<String> keySet() {
        return mHooks.keySet();
    }

    @Override
    public Hook put(String s, Hook hook) {
        return mHooks.put(s, hook);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Hook> map) {
        mHooks.putAll(map);
    }

    @Override
    public Hook remove(Object o) {
        return mHooks.remove(0);
    }

    @Override
    public int size() {
        return mHooks.size();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Collection<Hook> values() {
        return mHooks.values();
    }
}

