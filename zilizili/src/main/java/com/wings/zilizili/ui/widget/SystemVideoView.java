package com.wings.zilizili.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.VideoView;

/**
 * Created by wing on 2015/9/2.
 */
public class SystemVideoView extends VideoView {

    public boolean isFullScreen;
    private int mVideoWidth;
    private int mVideoHeight;

    public SystemVideoView(Context context) {
        super(context);
    }

    public SystemVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SystemVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (isFullScreen) {
            setMeasuredDimension(getLayoutParams().width, getLayoutParams().height);
        } else {
            int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
            int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
            setMeasuredDimension(width, height);
        }
    }

    public void setVideoSize(int height, int width, boolean isFullScreen) {
        System.out.println("setVideoSize");
        this.isFullScreen = isFullScreen;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (isFullScreen) {
            layoutParams.height = height;
            layoutParams.width = width;
        } else {
            layoutParams.height = height;
            layoutParams.width = width;
        }
        setLayoutParams(layoutParams);
        invalidate();
    }
}
