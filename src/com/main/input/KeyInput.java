package com.main.input;

import com.main.core.Handler;
import com.main.enums.ID;
import com.main.mainobjects.GameObject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false; //W key
        keyDown[1] = false; //S key
        keyDown[2] = false; //D key
        keyDown[3] = false; //A key
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                //key events for player

                if(key == KeyEvent.VK_W) {
                    keyDown[0] = true;
                    tempObject.setVelY(-5);
                }
                if(key == KeyEvent.VK_S) {
                    keyDown[1] = true;
                    tempObject.setVelY(5);
                }
                if(key == KeyEvent.VK_D) {
                    keyDown[2] = true;
                    tempObject.setVelX(5);
                }
                if(key == KeyEvent.VK_A) {
                    keyDown[3] = true;
                    tempObject.setVelX(-5);
                }

//                if(key == KeyEvent.VK_SPACE) tempObject.setVelY(-35);  jump (enable gravity in player.java)
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player) {
                //key events for player

                if(key == KeyEvent.VK_W) keyDown[0] = false;
                if(key == KeyEvent.VK_S) keyDown[1] = false;
                if(key == KeyEvent.VK_D) keyDown[2] = false;
                if(key == KeyEvent.VK_A) keyDown[3] = false;

                //vertical movement
                if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);

                //horizontal movement
                if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
            }
        }

        if(key == KeyEvent.VK_ESCAPE) System.exit(1);

    }

    public void lostFocus(){
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }
}
