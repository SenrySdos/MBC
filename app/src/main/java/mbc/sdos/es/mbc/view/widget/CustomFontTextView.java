package mbc.sdos.es.mbc.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import mbc.sdos.es.mbc.R;


public class CustomFontTextView extends TextView {
    private final static String TAG = "CustomFontTextView";

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomFontTextView(Context context) {
        super(context);
        init(null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        try {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } catch (IndexOutOfBoundsException e) {
            setText(getText().toString());
            Log.e(TAG, "onMeasure", e);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public void setGravity(int gravity) {
        try {
            super.setGravity(gravity);
        } catch (IndexOutOfBoundsException e) {
            setText(getText().toString());
            Log.e(TAG, "setGravity", e);
            super.setGravity(gravity);
        }
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        try {
            super.setText(text, type);
        } catch (IndexOutOfBoundsException e) {
            setText(text.toString());
            Log.e(TAG, "setText", e);
        }
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomFont);
            String fontName = a.getString(R.styleable.CustomFont_fontName);
            if (fontName != null) {
                try {
                    Typeface myTypeface = FontUtils.getTypeface(fontName, getContext());
                    setTypeface(myTypeface);
                } catch (Exception e) {
                    Log.e(TAG, "Font '" + fontName + "' not found.", e);
                }
            }
            a.recycle();
        }
    }


    public void setFontByName(String fontName) {
        if (fontName != null) {
            try {
                Typeface myTypeface = FontUtils.getTypeface(fontName, getContext());
                setTypeface(myTypeface);
            } catch (Exception e) {
                Log.e(TAG, "setFontByName", e);
            }
        }
    }

}
