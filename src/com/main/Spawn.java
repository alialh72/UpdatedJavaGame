package com.main;

import com.main.core.Handler;
import com.main.core.Position;
import com.main.enemies.*;
import com.main.enums.ID;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 200){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);


            if (hud.getLevel() == 2){
                Position randomPos = new Position(r.nextInt(GamePanel.WIDTH - 100), r.nextInt(GamePanel.HEIGHT - 100));
                handler.addObject(new SmartEnemy(randomPos, ID.SmartEnemy, handler));
            }

            if (hud.getLevel() == 4){
                Position randomPos = new Position(r.nextInt(GamePanel.WIDTH - 100), r.nextInt(GamePanel.HEIGHT - 100));
                handler.addObject(new FastEnemy(randomPos, ID.FastEnemy, handler));
            }

            if (hud.getLevel() == 6){
                Position randomPos = new Position(r.nextInt(GamePanel.WIDTH - 100), r.nextInt(GamePanel.HEIGHT - 100));
                handler.addObject(new StrongEnemy(randomPos, ID.StrongEnemy, handler));
            }

            if (hud.getLevel() % 2 == 0){
                Position randomPos = new Position(r.nextInt(GamePanel.WIDTH - 100), r.nextInt(GamePanel.HEIGHT - 100));
                handler.addObject(new BasicEnemy(randomPos, ID.Enemy, handler));
            }

            if (hud.getLevel() == 10){
                handler.clearEnemies();
                Position randomPos = new Position((GamePanel.WIDTH/2)-38, -150);
                handler.addObject(new EnemyBoss(randomPos, ID.EnemyBoss, handler));
            }


        }
    }

    public void reset() {
        scoreKeep = 0;
    }
}
