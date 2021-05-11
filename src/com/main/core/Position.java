package com.main.core;

public class Position {

    public float x, y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void addX(float x){
        this.x += x;
    }

    public void addY(float y){
        this.y += y;
    }

}
