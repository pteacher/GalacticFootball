package com.itsamsung.galacticfootball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by TEACHER on 22.02.2017.
 */
public class Drawer extends Thread {
    private SurfaceHolder surfaceHolder;
    private Paint mPaint = new Paint();
    private volatile boolean running = true;
    private ArrayList<Footballers> footballers = new ArrayList<Footballers>();
    private int footballersSize = 50;
    private int footballersCount = 8;

    public Drawer(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        Canvas canvas = surfaceHolder.lockCanvas();
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        for (int i = 0; i < footballersCount; i++) {
            footballers.add(new Footballers(width, height));
        }
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    mPaint.setColor(Color.BLUE);
                    mPaint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), mPaint);

                    for (int i = 0; i < footballersCount; i++) {
                        Random r = new Random();
                        mPaint.setColor(footballers.get(i).getColor());
                        // mPaint.setColor(Color.YELLOW);
                        footballers.get(i).moveRandom();
                        canvas.drawCircle(footballers.get(i).getX(),
                                footballers.get(i).getY(),
                                footballersSize, mPaint);
                        mPaint.setColor(Color.BLACK);
                        mPaint.setTextSize(50);
                        canvas.drawText(Integer.toString(footballers.get(i).getNumber()),
                                footballers.get(i).getX() - footballersSize / 2,
                                footballers.get(i).getY() + footballersSize / 2,
                                mPaint);
                    }
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
