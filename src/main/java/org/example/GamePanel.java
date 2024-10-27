package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public GamePanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setDoubleBuffered(true);
        this.setBackground(Color.GRAY);
    }

    Thread thread;

    public void startGame(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {

    }
}
