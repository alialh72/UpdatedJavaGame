package com.main.enemies;

import com.main.GamePanel;
import com.main.core.Handler;
import com.main.core.Position;
import com.main.core.Size;
import com.main.enums.ID;
import com.main.mainobjects.GameObject;
import com.main.mainobjects.Wall;

import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject {

    private Handler handler;
    private Size size = new Size(76, 76);
    Random r = new Random();

    private int timer = 100;
    private int timer2 = 50;




    public EnemyBoss(Position position, ID id, Handler handler) {
        super(position, id);

        this.handler = handler;

        velX = 0;
        velY = 2;
    }

    public void tick() {
        position.addX(velX);
        position.addY(velY);

        if(timer <= 0) {
            velY = 0;
            timer2--;
        }
        else timer--;

        if(timer2 <= 0){
            if (velX ==0) velX = 2;
            int spawn = r.nextInt(10);
            if(spawn == 0) handler.addObject(new EnemyBossBullet(new Position(position.x + 38, position.y + 38), ID.Enemy, handler));
        }

        if(position.x <= 0 || position.x >= GamePanel.WIDTH - 90) velX *= -1;

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
        g.setColor(Color.red);
        g.fillRect((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }
}
