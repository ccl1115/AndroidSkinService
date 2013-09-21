package com.simon.catkins.skin;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Any activity extends this activity will have the skin service affected.
 *
 * @author Simon Yu
 */
public class ActivityWithSkin extends Activity {

    /**
     * Use the delegate instead of extending this class.
     *
     * @param activity the target activity
     * @return the delegate of lifecycle callbacks
     */
    public static Delegate getDelegate(Activity activity) {
        return new DelegateImpl(activity);
    }

    public interface Delegate {
        void onCreatePre();

        void onResume();
    }

    private Delegate mDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDelegate = new DelegateImpl(this);

        mDelegate.onCreatePre();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDelegate.onResume();
    }

    private static class DelegateImpl implements Delegate {
        private Activity mActivity;

        public DelegateImpl(Activity activity) {
            mActivity = activity;
        }


        @Override
        public void onCreatePre() {
            LayoutInflater layoutInflater
                    = (LayoutInflater) mActivity.getSystemService(LAYOUT_INFLATER_SERVICE);

            layoutInflater.setFactory(SkinService.getInflaterFactory());
        }

        @Override
        public void onResume() {
            SkinService.applySkin(mActivity);
        }
    }
}
