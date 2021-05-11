package com.main.gamestates.manager;

import com.main.gamestates.manager.GameStateManager;

import java.awt.*;

public abstract class GameState extends Canvas{


    protected GameStateManager gsm;

    public abstract void init();
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void disableGUi();


}
