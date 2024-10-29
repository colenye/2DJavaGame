package org.example;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 16;

    final int tileSize = originalTileSize * scale;

    KeyHandler keyHandler = new KeyHandler();

    int playerX = 50;
    int playerY = 50;
    int playerSpeed = 41;

    final int FPS = 60;
    public GamePanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setDoubleBuffered(true);
        this.setBackground(Color.GRAY);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    Thread thread;

    public void startGame(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        double delta = 1;
        long lastTime = System.nanoTime();
        long currentTime;
        while(thread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime);

            lastTime = currentTime;


            if(delta >= 1000000000d / FPS) {
                update();
                repaint();
                delta=0;
            }
        }
    }
    public void update() {
        if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        }
        if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
        if (keyHandler.upPressed) {
            playerY -= playerSpeed;
        }
        if (keyHandler.downPressed) {
            playerY += playerSpeed;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
//