package com.main.gamestates;

import com.main.GamePanel;
import com.main.gamestates.manager.GameState;
import com.main.gamestates.manager.GameStateManager;
import com.main.input.MouseInput;

import java.awt.*;

public class GameOver extends GameState {

    private GameStateManager gsm;
    private GamePanel panel;
    private MouseInput mouseInput;


    public GameOver(GameStateManager gsm, GamePanel panel) {
        this.gsm = gsm;
        this.panel = panel;

    }

    public void init() {
        mouseInput = new MouseInput(gsm);
        panel.addMouseListener(mouseInput);
    }


    public void tick() { }


    public void render(Graphics g) {
        //-------------game over------------------
        Font mainFont = new Font("Arial", Font.BOLD, 40);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        //main menu text
        g.setColor(Color.WHITE);
        g.setFont(mainFont);
        g.drawString("Game Over", GamePanel.WIDTH/2 - 100, 90);

        //buttons

        g.drawRect(GamePanel.WIDTH/2 - 100, 225, 200, 64);
        g.setFont(buttonFont);
        g.drawString("Play Again", GamePanel.WIDTH/2 - 50, 262);

        g.drawRect(GamePanel.WIDTH/2 - 100, 325, 200, 64);
        g.setFont(buttonFont);
        g.drawString("Quit", GamePanel.WIDTH/2 - 20, 362);
    }


    public void disableGUi() {
        panel.removeMouseListener(mouseInput);
    }
}
