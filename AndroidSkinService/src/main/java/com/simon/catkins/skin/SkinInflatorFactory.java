package com.simon.catkins.skin;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * InflatorFactory to bind hooks to views.
 *
 * @author yulu02
 */
public class SkinInflatorFactory implements LayoutInflater.Factory {
    private static final String TAG = "SkinInflatorFactory";

    private HookSet[] mHookSets;

    private static final String LOAD_PREFIX = "android.widget.";

    private final Map<String, Constructor<? extends View>> mConstructors;

    private final DisplayMetrics mDisplayMetrics;
    private final Resources mRes;

    public SkinInflatorFactory(Context context) {
        mConstructors = new HashMap<String, Constructor<? extends View>>();
        mDisplayMetrics = context.getResources().getDisplayMetrics();
        mRes = context.getResources();
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        long now;
        if (BuildConfig.DEBUG) {
            now = SystemClock.uptimeMillis();
        }
        View view;
        try {
            Constructor<? extends View> constructor;
            Class<? extends View> c;
            constructor = mConstructors.get(name);
            if (constructor == null) {
                ClassLoader classLoader = context.getClassLoader();
                if (classLoader != null) {
                    c = classLoader.loadClass(name.contains(".") ? name : LOAD_PREFIX + name).asSubclass(View.class);
                    constructor = c.getConstructor(Context.class, AttributeSet.class);
                    mConstructors.put(name, constructor);
                    view = constructor.newInstance(context, attrs);
                } else {
                    return null;
                }
            } else {
                view = constructor.newInstance(context, attrs);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

        if (BuildConfig.DEBUG) {
            Log.d(TAG, "view name = " + name);
            final int count = attrs.getAttributeCount();
            for (int i = 0; i < count; i++) {
                Log.v(TAG, "attribute " + i + " : " + attrs.getAttributeName(i) + ":" + attrs.getAttributeValue(i));
            }
        }

        if (mHookSets == null || mHookSets.length == 0) return view;

        final List<ValueInfo> infos = new ArrayList<ValueInfo>();

        for (HookSet hookSet : mHookSets) {
            for (Hook hook : hookSet.values()) {
                final String value = attrs.getAttributeValue(hookSet.getNamespace(), hook.hookName());
                if (value == null) {
                    continue;
                }
                TypedValue tv = null;
                final int hookType = hook.hookType();
                if ((hookType & HookType.REFERENCE_ID) == HookType.REFERENCE_ID) {
                    tv = TypedValueParser.parseReference(value, mRes);
                }
                if (tv == null) {
                    if ((hookType & HookType.COLOR) == HookType.COLOR) {
                        tv = TypedValueParser.parseColor(value);
                    } else if ((hookType & HookType.STRING) == HookType.STRING) {
                        tv = TypedValueParser.parseString(value);
                    } else if ((hookType & HookType.FLOAT) == HookType.FLOAT) {
                        tv = TypedValueParser.parseFloat(value);
                    } else if ((hookType & HookType.INTEGER) == HookType.INTEGER) {
                        tv = TypedValueParser.parseInt(value);
                    } else if ((hookType & HookType.BOOLEAN) == HookType.BOOLEAN) {
                        tv = TypedValueParser.parseInt(value);
                    } else if ((hookType & HookType.DIMENSION) == HookType.DIMENSION) {
                        tv = TypedValueParser.parseDimension(value, mDisplayMetrics);
                    }
                }
                if (tv == null) continue;

                if (hook.shouldHook(view, tv)) {
                    infos.add(new ValueInfo(hookSet.getPrefix(), tv, hook.getApply()));
                }
            }
        }

        if (infos.size() > 0) {
            ViewTagger.setTag(view, R.id.skin_hooker, infos);
        }

        if (BuildConfig.DEBUG) {
            now = SystemClock.uptimeMillis() - now;
            Log.d(TAG, "inflate view time = " + now);
        }

        Loot.logInflate("Inflated a view: " + name + " using SkinInflatorFactory");
        return view;
    }

    void addHookSet(HookSet hookSet) {
        if (mHookSets == null) {
            HookSet[] n = new HookSet[1];
            n[0] = hookSet;
            mHookSets = n;
        } else {
            HookSet[] n = new HookSet[mHookSets.length + 1];
            System.arraycopy(mHookSets, 0, n, 0, mHookSets.length);
            n[mHookSets.length] = hookSet;
            mHookSets = n;
        }
    }

}
