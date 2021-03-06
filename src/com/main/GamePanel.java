package com.main;

import com.main.gamestates.manager.GameStateManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Window window;

    private boolean running = false;
    private Thread thread;


    private GameStateManager gsm;
//    private Camera camera;


    //Main menu

    public enum STATE {
        Menu,
        Help,
        GameOver,
        Game
    };

    public GamePanel(){
        gsm = new GameStateManager(this);

        window = new Window(WIDTH, HEIGHT, "Game Test", this);

//        camera = new Camera(0, 0, handler);

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void run() {
        this.requestFocus();


        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
                tick();
                delta--;
            }

            if(running)
                render();

            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

        stop();

    }



    private void tick() {
        gsm.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
//        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

//        g2d.translate(-camera.getX(), -camera.getY());

        gsm.render(g);



//        g2d.translate(camera.getX(), camera.getY());



        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max){
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
    }



    public static void main(String[] args) {
        new GamePanel();
    }


}
