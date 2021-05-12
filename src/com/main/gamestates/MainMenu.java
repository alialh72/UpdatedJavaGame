package com.main.gamestates;


import com.main.GamePanel;
import com.main.gamestates.manager.GameState;
import com.main.gamestates.manager.GameStateManager;
import com.main.input.MouseInput;
import com.main.tilemap.Background;


import java.awt.*;

public class MainMenu extends GameState {

    private Background bg;
    private GameStateManager gsm;
    private GamePanel panel;
    private MouseInput mouseInput;


    public MainMenu(GameStateManager gsm, GamePanel panel) {
        this.gsm = gsm;
        this.panel = panel;

        bg = new Background("/backgroundimage.png", 1);
        bg.setVector(-0.1f, 0);
    }

    public void init() {
        mouseInput = new MouseInput(gsm);
        panel.addMouseListener(mouseInput);;
    }


    public void tick(){
        bg.tick();
    }

    public void render(Graphics g){

        bg.render(g);

        //-------------main menu------------------

        Font mainFont = new Font("Arial", Font.PLAIN, 40);
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        //main menu text
        g.setColor(Color.WHITE);
        g.setFont(mainFont);
        g.drawString("Main Menu", GamePanel.WIDTH/2 - 100, 60);

        //buttons
        g.drawRect(GamePanel.WIDTH/2 - 100, 125, 200, 64);
        g.setFont(buttonFont);
        g.drawString("Play", GamePanel.WIDTH/2 - 20, 162);

        g.drawRect(GamePanel.WIDTH/2 - 100, 225, 200, 64);
        g.setFont(buttonFont);
        g.drawString("Help", GamePanel.WIDTH/2 - 20, 262);

        g.drawRect(GamePanel.WIDTH/2 - 100, 325, 200, 64);
        g.setFont(buttonFont);
        g.drawString("Quit", GamePanel.WIDTH/2 - 20, 362);



    }

    @Override
    public void disableGUi() {
        panel.removeMouseListener(mouseInput);
    }


}
