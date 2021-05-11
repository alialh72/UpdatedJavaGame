package com.main.input;

import com.main.GamePanel;
import com.main.gamestates.manager.GameStateManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private GameStateManager gsm;

    public MouseInput(GameStateManager gsm){
        this.gsm = gsm;
    }

    public void mousePressed(MouseEvent e){


    }

    public void mouseReleased(MouseEvent e){

        if (gsm.getCurrentState() == GameStateManager.STATES.MENU){
            mouseReleasedMainMenu(e);
        }
        else if (gsm.getCurrentState() == GameStateManager.STATES.GAMEOVER){
            mouseReleasedGameOver(e);
        }

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }  return false;
        } return false;
    }

    private void mouseReleasedMainMenu(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        //main menu button

        if (mouseOver(mx, my, GamePanel.WIDTH/2 - 100, 125, 200, 64)){
            gsm.switchState(GameStateManager.STATES.GAME);
        }

        //help button
        if (mouseOver(mx, my, GamePanel.WIDTH/2 - 100, 225, 200, 64)){
            gsm.switchState(GameStateManager.STATES.GAME);
        }

        //quit button
        if (mouseOver(mx, my, GamePanel.WIDTH/2 - 100, 325, 200, 64)){
            System.exit(1);
        }
    }

    private void mouseReleasedGameOver(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        //play again button
        if (mouseOver(mx, my, GamePanel.WIDTH/2 - 100, 225, 200, 64)){
            gsm.switchState(GameStateManager.STATES.GAME);
        }

        //quit button
        if (mouseOver(mx, my, GamePanel.WIDTH/2 - 100, 325, 200, 64)){
            System.exit(1);
        }
    }




}
