package com.main.enemies;

import com.main.core.Handler;
import com.main.core.Position;
import com.main.core.Size;
import com.main.enums.ID;
import com.main.mainobjects.GameObject;
import com.main.mainobjects.Trail;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private Size size = new Size(22, 22);
    private GameObject player;


    public SmartEnemy(Position position, ID id, Handler handler) {
        super(position, id);

        this.handler = handler;

        for (GameObject g : handler.object){
            if (g.getId() == ID.Player) player = g;
        }
    }

    public void tick() {
        position.addX(velX);
        position.addY(velY);

        //calculate diff between player and enemy
        float diffX = position.x - player.getX() - 8;
        float diffY = position.y - player.getY() - 8;
        float distance = (float) Math.sqrt(  (position.x- player.getX()) * (position.x- player.getX())   +   (position.y- player.getY()) * (position.y- player.getY())   ); //pythagorean theorem

        velX = ((-1/distance) * diffX);
        velY = ((-1/distance) * diffY);


//        if(position.y <= 0 || position.y >= Game.HEIGHT - 56) velY *= -1;
//        if(position.x <= 0 || position.x >= Game.WIDTH - 32) velX *= -1;

        //trail
        handler.addObject(new Trail(position, ID.Trail, Color.PINK, size, 0.05f, handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }
}
