package com.main.mainobjects;

import com.main.GamePanel;
import com.main.HUD;
import com.main.core.Handler;
import com.main.core.Position;
import com.main.core.Size;
import com.main.enums.ID;

import java.awt.*;
import java.util.Random;

import static com.main.GamePanel.HEIGHT;
import static com.main.GamePanel.WIDTH;

public class Player extends GameObject {

    private Size size = new Size(32, 32);
    private Random r = new Random();
    Handler handler;

    public Player(Position position, ID id,Handler handler) {
        super(position, id);
        this.handler = handler;

    }

    @Override
    public void tick() {

        position.addX(velX);
        position.addY(velY);



        setX(GamePanel.clamp((int) position.x, 0, WIDTH - 48));
        setY(GamePanel.clamp((int) position.y, 0, HEIGHT - 71));

//        x = Game.clamp(x, 0, Game.WIDTH - 48);
//        y = Game.clamp(y, 0, Game.HEIGHT - 71);

//        velY += 4.9;  gravity

        //trail
        handler.addObject(new Trail(position, ID.Trail, Color.white, size, 0.05f, handler));

        collision();
    }

    private void collision() {
        //check object collision
        for (GameObject temp: handler.object){
            if (temp.getId() == ID.Enemy || temp.getId() == ID.FastEnemy || temp.getId() == ID.SmartEnemy){
                if (getBounds().intersects(temp.getBounds())){
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }
            else if (temp.getId() == ID.StrongEnemy){
                if (getBounds().intersects(temp.getBounds())){
                    //collision code
                    HUD.HEALTH -= 8;
                }
            }
            else if (temp.getId() == ID.EnemyBoss){
                if (getBounds().intersects(temp.getBounds())){
                    //collision code
                    HUD.HEALTH -= 1000;
                }
            }
        }

        //check wall collision
        int tempbounds = getBounds().x;
        tempbounds += velX;
        for (Wall wall : handler.walls){
            if (getBounds().intersects(wall.bounds)){
                position.addX(-velX);
                position.addY(-velY);
            }
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) position.x, (int) position.y, size.getWidth(), size.getHeight());
    }
}
