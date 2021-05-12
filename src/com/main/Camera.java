package com.main;

import com.main.core.Handler;
import com.main.enums.ID;
import com.main.mainobjects.GameObject;

public class Camera {

    private float x, y;
    private Handler handler;
    private GameObject tempPlayer = null;

    public Camera(int x, int y, Handler handler) {
        this.x = x;
        this.y = y;
        this.handler = handler;

        findPlayer();
    }

    public void findPlayer(){
        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player){
                tempPlayer = handler.object.get(i);
                break;
            }
        }
    }

    public void tick(){

        if (tempPlayer != null){
            x = tempPlayer.getX() - GamePanel.WIDTH/2 + 16;
            y = tempPlayer.getY() - GamePanel.HEIGHT/2 + 16;
        }
        else{
            findPlayer();
        }
    }

    public void render(){

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
