package com.main.mainobjects;

import com.main.core.Position;
import com.main.core.Size;

import java.awt.*;

public class Wall {

    public Position position;
    public Size size;

    public Rectangle bounds;

    public Wall(Position position, Size size) {
        this.position = position;
        this.size = size;

        bounds = new Rectangle( (int) position.x, (int) position.y, size.width, size.height);
    }

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

//        g2d.setColor(Color.MAGENTA);
//        g2d.drawRect( (int) position.x, (int) position.y, size.width, size.height);

        g2d.setColor(Color.MAGENTA);
        g2d.fillRect( (int) position.x, (int) position.y, size.width, size.height);
    }
}
