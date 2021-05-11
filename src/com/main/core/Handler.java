package com.main.core;

import com.main.enums.ID;
import com.main.mainobjects.GameObject;
import com.main.mainobjects.Player;
import com.main.mainobjects.Wall;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    public LinkedList<Wall> walls = new LinkedList<Wall>();

    public void tick(){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }

        for (Wall wall : walls){
            wall.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void addWall(Wall wall){
        walls.add(wall);
    }

    public void clearEnemies() {
        for (GameObject temp : object){
            if (temp.getId() == ID.Player){
                object.clear();
                addObject(new Player(temp.getPosition(), ID.Player, this));
            }
        }
    }
}
