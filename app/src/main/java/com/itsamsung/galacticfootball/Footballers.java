package com.itsamsung.galacticfootball;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;
import java.util.Set;

/**
 * Created by TEACHER on 22.02.2017.
 */
public class Footballers {
    private int number;
    private int x;
    private int y;
    private int c;

    public Footballers(int screenWidth, int screenHeight) {
        Random rand = new Random();
        number = rand.nextInt(99) + 1;
        x = rand.nextInt(screenWidth);
        y = rand.nextInt(screenHeight);

        c = Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void moveRandom() {
        x += (int) (Math.random() * 5) - 2;
        y += (int) (Math.random() * 5) - 2;
    }

    public int getColor() {
        return c;
    }

    public void setColor(int c) {
        this.c = c;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
