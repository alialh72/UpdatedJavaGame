package com.main.gamestates.manager;

import com.main.GamePanel;
import com.main.gamestates.Game;
import com.main.gamestates.GameOver;
import com.main.gamestates.MainMenu;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    private GamePanel panel;
    private ArrayList<GameState> gameStates;
    private STATES currentState;

    public enum STATES {
        MENU(0),
        GAME(1),
        GAMEOVER(2);

        private final int index;

        STATES(final int index) {
            this.index = index;
        }

        public int getStateIndex(){return index;}
    }

    public GameStateManager(GamePanel panel){

        this.panel = panel;
        gameStates = new ArrayList<GameState>();


        gameStates.add(new MainMenu(this, panel));
        gameStates.add(new Game(this, panel));
        gameStates.add(new GameOver(this, panel));

        setState(STATES.MENU);

    }

    public void setState(STATES State){
        currentState = State;
        gameStates.get(currentState.getStateIndex()).init();
    }

    public STATES getCurrentState(){
        return currentState;
    }

    public void switchState(STATES State){
        gameStates.get(currentState.getStateIndex()).disableGUi();
        currentState = State;
        gameStates.get(currentState.getStateIndex()).init();
    }

    public void tick(){
        gameStates.get(currentState.getStateIndex()).tick();
    }

    public void render(Graphics g){
        gameStates.get(currentState.getStateIndex()).render(g);
    }

}
