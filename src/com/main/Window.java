package com.main;

import javax.swing.*;
import java.awt.*;
import java.awt.Canvas;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Window extends Canvas {

    public JFrame frame;

    public Window(int width, int height, String title, GamePanel gamePanel){
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(gamePanel);

        frame.setVisible(true);

        System.out.println("game starting");
        gamePanel.start();

    }



}
