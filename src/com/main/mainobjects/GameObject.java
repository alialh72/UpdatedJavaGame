package com.main.mainobjects;

import com.main.core.Position;
import com.main.enums.ID;

import java.awt.*;

public abstract class GameObject {

    protected Position position;
    protected ID id;
    protected float velX, velY;

    public GameObject(Position position, ID id) {
        this.position = position;
//        this.x = position.getX();
//        this.y = position.getY();
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public Position getPosition() { return position; }

    public float getX() {
        return position.getX();
    }

    public float getY() {
        return position.getY();
    }

    public ID getId() {
        return id;
    }

    public void setX(float x) {
        position.setX(x);
    }

    public void setY(float y) {
        position.setY(y);
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }
}
