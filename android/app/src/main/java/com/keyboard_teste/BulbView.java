package com.keyboard_teste;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

public class BulbView extends androidx.appcompat.widget.AppCompatButton {
    public BulbView(Context context) {
        super(context);
        this.setTextColor(Color.BLUE);
        this.setText("This button is created from JAVA code");
    }

    public BulbView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BulbView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
