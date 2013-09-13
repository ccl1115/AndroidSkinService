package com.simon.catkins.skin;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Stack;

import com.simon.catkins.skin.impl.*;

/**
 * @author yulu02
 */
public class SkinService {

    private static SkinInflatorFactory sSkinInflatorFactory;

    public synchronized static SkinInflatorFactory getFactory(Context context) {
        if (sSkinInflatorFactory == null) {
            sSkinInflatorFactory = new SkinInflatorFactory(context);
            sSkinInflatorFactory.addHookSet(new DaySkin());
            sSkinInflatorFactory.addHookSet(new NightSkin());
        }
        return sSkinInflatorFactory;
    }

    private static String mSkin;

    public static String getTheme() {
        return mSkin;
    }

    public static void applySkin(Activity activity) {
        mSkin = activity.getSharedPreferences("default", Context.MODE_PRIVATE).getString("skin", DaySkin.NAME);
        Loot.logApply("Applying skin [" + mSkin + "] to activity " + activity.getClass().getSimpleName());
        applyViews(activity.findViewById(android.R.id.content));
    }

    public static void applySkin(Activity activity, String skin) {
        mSkin = skin;
        activity.getSharedPreferences("default", Context.MODE_PRIVATE).edit().putString("skin", mSkin).apply();
        Loot.logApply("Applying skin [" + mSkin + "] to activity " + activity.getClass().getSimpleName());
        applyViews(activity.findViewById(android.R.id.content));
    }

    private static void applyViews(View root) {
        if (mSkin == null) return;

        Loot.logApply("Loop the view tree: " + root);
        Stack<View> stack = new Stack<View>();
        stack.push(root);

        while (!stack.isEmpty()) {
            View v = stack.pop();

            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                final int count = vg.getChildCount();
                for (int i = 0; i < count; i++) {
                    stack.push(vg.getChildAt(i));
                }
            } else {
                @SuppressWarnings("unchecked")
                List<ValueInfo> list = (List<ValueInfo>) ViewTagger.getTag(v, R.id.skin_hooker);

                if (list == null) {
                    continue;
                }

                Loot.logApply("Apply skin [" + mSkin + "] to view id: " + Integer.toHexString(v.getId()));
                for (ValueInfo info : list) {
                    if (mSkin.equals(info.skin)) {
                        info.apply.to(v, info.typedValue);
                    }
                }
            }
        }
    }
}
