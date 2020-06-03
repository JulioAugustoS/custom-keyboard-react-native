package com.keyboard_teste;

import android.inputmethodservice.InputMethodService;
import android.view.View;

public class MyInputMethodService extends InputMethodService {
    private RNKeyboardView rnKeyboardView;

    public MyInputMethodService() {
        super();
        rnKeyboardView = new RNKeyboardView();
    }

    @Override
    public View onCreateInputView() {
        return rnKeyboardView.createCustomKeyboardView();
    }

}
