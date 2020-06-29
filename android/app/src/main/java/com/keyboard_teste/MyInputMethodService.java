package com.keyboard_teste;

import android.graphics.Color;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class MyInputMethodService extends InputMethodService implements DefaultHardwareBackBtnHandler {
    private @Nullable ReactInstanceManager mReactInstanceManager;
    private @Nullable ReactRootView mReactRootView;

    private LifecycleState mLifecycleState = LifecycleState.BEFORE_RESUME;

    private View v;

    @Override
    public View onCreateInputView() {
        android.os.Debug.waitForDebugger();
        try {
            v = getLayoutInflater().inflate(R.layout.keyboard_view, null);
            v.setBackgroundColor(Color.BLACK);

            mReactInstanceManager = ReactInstanceManager.builder()
                    .setApplication(getApplication())
                    .setBundleAssetName("index.android.bundle")
                    .setJSMainModulePath("index")
                    .addPackage(new MainReactPackage())
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    .build();

            mReactRootView = createRootView();
            mReactRootView.startReactApplication(mReactInstanceManager, getMainComponentName(), getLaunchOptions());

            ViewGroup insertPoint = (ViewGroup) v.findViewById(R.id.react_test_id);
            insertPoint.addView(mReactRootView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            v.invalidate();
        } catch (Exception e) {
            int z = 1;
            int y = 2;
        }

        return v;
    }

    protected @Nullable Bundle getLaunchOptions() {
        Bundle b = new Bundle();
        b.putString("mode", "keyboard");

        return b;
    }

    protected ReactRootView createRootView() {
        return new ReactRootView(this);
    }

    protected String getMainComponentName() {
        return "RNCustomKeyboard";
    }

    @Override
    public void invokeDefaultOnBackPressed() {

    }
}
