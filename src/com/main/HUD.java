package com.main;

import com.main.gamestates.manager.GameStateManager;

import java.awt.*;

public class HUD {

    public static float HEALTH = 100;
    public GameStateManager gsm;

    private float greenValue = 255;

    private int score = 0;
    private int level = 1;

    public HUD(GameStateManager gsm){
        this.gsm = gsm;
    }

    public void tick(){

        HEALTH = GamePanel.clamp(HEALTH, 0, 100);
        greenValue = GamePanel.clamp(greenValue, 0, 255);

        greenValue = HEALTH*2;

        score++;

        if(HEALTH <= 0){
            gsm.switchState(GameStateManager.STATES.GAMEOVER);
        }
    }

    public void render(Graphics g){
        //healthbar
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);

        g.setColor(new Color(75, (int) greenValue, 0));
        g.fillRect(15,15, (int) (HEALTH * 2), 32);

        g.setColor(Color.white);
        g.drawRect(15,15,200, 32);

        g.drawString(HEALTH + " / 100", 225, 35);

        g.drawString("Score: "+score, 15, 65);
        g.drawString("Level: "+ level, 15, 80);

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void reset() {
        HEALTH = 100;
        greenValue = 255;

        score = 0;
        level = 1;
    }
}
