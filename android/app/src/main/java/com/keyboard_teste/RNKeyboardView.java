package com.keyboard_teste;

import android.app.Activity;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class RNKeyboardView extends ReactContextBaseJavaModule {
    @NonNull
    @Override
    public String getName() {
        return "RNCustomKeyboard";
    }

    ReactRootView rootView = null;

    public RelativeLayout createCustomKeyboardView() {
        final Activity activity = getCurrentActivity();

        RelativeLayout layout = new RelativeLayout(activity);
        rootView = new ReactRootView(this.getReactApplicationContext());
        rootView.setBackgroundColor(Color.GREEN);

//        Bundle bundle = new Bundle();

        final float scale = activity.getResources().getDisplayMetrics().density;
        RelativeLayout.LayoutParams lParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Math.round(216*scale));
        lParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        layout.addView(rootView, lParams);

        return layout;
    }

}
