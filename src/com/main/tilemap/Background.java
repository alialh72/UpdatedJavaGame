package com.main.tilemap;

import com.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {

    BufferedImage image;

    private float x, y, dx, dy;
    private float moveScale;

    public Background(String path, float ms){
        try {
            image = ImageIO.read(getClass().getResource(path));
            moveScale = ms;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPosition(float x, float y){
        this.x = (x * moveScale) % GamePanel.HEIGHT;
        this.y = (y * moveScale) % GamePanel.HEIGHT;
    }

    public void setVector(float dx, float dy){
        this.dx = dx;
        this.dy = dy;
    }

    public void tick(){
        x += dx;
        y += dy;
    }

    public void render(Graphics g){
        g.drawImage(image, (int) x, (int) y, null);

        if (x < 0){
            g.drawImage(image, (int) x + GamePanel.WIDTH, (int) y, null);
        }
        if (x > 0){
            g.drawImage(image, (int) x - GamePanel.WIDTH, (int) y, null);
        }

        if (y < 0){
            g.drawImage(image, (int) x, (int) y + GamePanel.HEIGHT, null);
        }
        if (y > 0){
            g.drawImage(image, (int) x, (int) y - GamePanel.HEIGHT, null);
        }
    }


}
