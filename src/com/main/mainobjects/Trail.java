package com.main.mainobjects;

import com.main.core.Handler;
import com.main.core.Position;
import com.main.core.Size;
import com.main.enums.ID;

import java.awt.*;

public class Trail extends GameObject {

    private float x, y;

    private float alpha = 1;
    private float life;

    private Handler handler;
    private Color color;

    private Size size;



    public Trail(Position position, ID id, Color color, Size size, float life, Handler handler) {
        super(position, id);

        this.x = position.getX();
        this.y = position.getY();
        this.color = color;
        this.handler = handler;
        this.size = size;
        this.life = life;
    }

    public void tick() {
        if (alpha > life){
            alpha -= (life - 0.001f);
        } else {
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);

        g.fillRect((int) x,(int) y, size.getWidth(), size.getHeight());

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public Rectangle getBounds() {
        return null;
    }
}
