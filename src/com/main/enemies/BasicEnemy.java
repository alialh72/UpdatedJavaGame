package com.main.enemies;

import com.main.GamePanel;
import com.main.core.Handler;
import com.main.core.Position;
import com.main.core.Size;
import com.main.enums.ID;
import com.main.mainobjects.GameObject;
import com.main.mainobjects.Trail;
import com.main.mainobjects.Wall;

import java.awt.*;

public class BasicEnemy extends GameObject {

    private Handler handler;
    private Size size = new Size(16, 16);
    private Color color = Color.red;


    public BasicEnemy(Position position, ID id, Handler handler) {
        super(position, id);

        this.handler = handler;

        velX = 4;
        velY = 4;

    }

    public void tick() {
        position.addX(velX);
        position.addY(velY);

        if(position.y <= 0 || position.y >= GamePanel.HEIGHT - 56) velY *= -1;

        if(position.x <= 0 || position.x >= GamePanel.WIDTH - 32) velX *= -1;

        //trail
        handler.addObject(new Trail(position, ID.Trail, color, size, 0.05f, handler));

        collision();
    }

    private void collision() {

        //check wall collision

        for (Wall wall : handler.walls){
            if (getBounds().intersects(wall.bounds)){
                velX *= -1;
                velY *= -1;
            }
        }

    }


    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }
}
