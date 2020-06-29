package com.keyboard_teste;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.uimanager.ReactRoot;

public class RNKeyboardView extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNKeyboardView(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "CustomKeyboardView";
    }

    ReactRootView rootView = null;

    public View createCustomKeyboardView(Activity activity) {
        RelativeLayout layout = new RelativeLayout(activity);
        rootView = new ReactRootView(this.getReactApplicationContext());
//        rootView.setBackground(Color.BLACK);

        Bundle bundle = new Bundle();
        rootView.startReactApplication(
                ((ReactApplication) activity.getApplication()).getReactNativeHost().getReactInstanceManager(),
                "CustomKeyboardView",
                bundle);

        final float scale = activity.getResources().getDisplayMetrics().density;
        RelativeLayout.LayoutParams lParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Math.round(216*scale));
        layout.addView(rootView, lParams);

        return layout;
    }
}
