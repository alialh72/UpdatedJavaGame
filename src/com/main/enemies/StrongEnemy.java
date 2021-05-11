package com.main.enemies;

import com.main.GamePanel;
import com.main.core.Handler;
import com.main.core.Position;
import com.main.core.Size;
import com.main.enums.ID;
import com.main.mainobjects.GameObject;
import com.main.mainobjects.Trail;

import java.awt.*;

public class StrongEnemy extends GameObject {

    private Handler handler;
    private Size size = new Size(20, 20);


    public StrongEnemy(Position position, ID id, Handler handler) {
        super(position, id);

        this.handler = handler;

        velX = 2;
        velY = 2;
    }

    public void tick() {
        position.addX(velX);
        position.addY(velY);

        if(position.y <= 0 || position.y >= GamePanel.HEIGHT - 56) velY *= -1;

        if(position.x <= 0 || position.x >= GamePanel.WIDTH - 32) velX *= -1;

        //trail
        handler.addObject(new Trail(position, ID.Trail, Color.YELLOW, size, 0.05f, handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }
}
