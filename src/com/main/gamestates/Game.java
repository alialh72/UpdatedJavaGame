package com.main.gamestates;

import com.main.*;
import com.main.Window;
import com.main.core.Handler;
import com.main.core.Position;
import com.main.core.Size;
import com.main.enemies.BasicEnemy;
import com.main.enums.ID;
import com.main.gamestates.manager.GameState;
import com.main.gamestates.manager.GameStateManager;
import com.main.input.KeyInput;
import com.main.mainobjects.Player;
import com.main.mainobjects.Wall;
import com.main.tilemap.Background;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends GameState {

    private Background bg;

    private Window window;
    private GamePanel panel;

    private boolean running = false;
    private Thread thread;

    private Random r;

    private Handler handler;
    private HUD hud;
    private KeyInput keyInput;
    private GameStateManager gsm;
    private Spawn spawner;


    public static BufferedImage sprite_sheet;

    public Game(GameStateManager gsm, GamePanel panel){
        BufferedImageLoader loader = new BufferedImageLoader();
        sprite_sheet = loader.loadImage("/sprite_sheet.png");


        this.panel = panel;
        this.gsm = gsm;

        handler = new Handler();

        hud = new HUD(gsm);

//        camera = new Camera(0, 0, handler);

        spawner = new Spawn(handler, hud);

        keyInput = new KeyInput(handler);

    }

    public void init() {

//        camera = new Camera(0, 0, handler);


        resetGame();

        panel.addKeyListener(keyInput);

        //checks if user clicked off the game
        panel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("lost focus");
                keyInput.lostFocus();  //if so, then sets all booleans to false (under keyinput)
            }
        });

        r = new Random();

        //player
        Position playerPos = new Position(GamePanel.WIDTH/2-32, GamePanel.HEIGHT/2-32);
        Player player = new Player(playerPos, ID.Player,handler);
        handler.addObject(player);

        //first enemy
        Position randomPos = new Position(r.nextInt(GamePanel.WIDTH - 50), r.nextInt(GamePanel.HEIGHT - 50));
        BasicEnemy basicEnemy = new BasicEnemy(randomPos, ID.Enemy, handler);
        handler.addObject(basicEnemy);

        //makeWalls();
    }

    public void tick() {
        handler.tick();
        hud.tick();
        spawner.tick();
    }

    public void render(Graphics g) {
        handler.render(g);
        hud.render(g);
    }

    @Override
    public void disableGUi() {
        panel.removeKeyListener(keyInput);
    }

    public void resetGame(){
        spawner.reset();
        hud.reset();
        handler.object.clear();
    }

    private void makeWalls(){
        for (int i = 40; i <= 400; i += 40){
            handler.addWall(new Wall(new Position(i, 122), new Size(40, 40)));
        }
        handler.addWall(new Wall(new Position(400, 162), new Size(40, 40)));
        handler.addWall(new Wall(new Position(400, 202), new Size(40, 40)));
    }
}
