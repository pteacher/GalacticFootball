package com.itsamsung.galacticfootball;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by TEACHER on 22.02.2017.
 */
public class DrawView extends SurfaceView implements SurfaceHolder.Callback {
    private Drawer drawer;

    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawer = new Drawer(getContext(), holder);
        drawer.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
