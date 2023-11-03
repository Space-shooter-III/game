package com.github.spaceshooteriii.game.display.compoments;

import com.github.spaceshooteriii.game.Game;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;
    private final int FPS;

    public GamePanel() {
        this.FPS = 60;

        this.setDoubleBuffered(true);
    }

    public void startGameLoop() {
        this.gameThread = new Thread(this);
        this.gameThread.setDaemon(false);
        this.gameThread.start();
    }


    @Override
    public void run() {
        this.requestFocus();

        double drawInterval = (double) (1000000000 / this.FPS);
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0L;
        int drawCount = 0;

        while (this.gameThread != null) {

            currentTime = System.nanoTime();

            delta += (double) ((double) (currentTime - lastTime) / drawInterval);
            timer += (long) (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1) {

                this.update();

                this.repaint();


                delta--;

                drawCount++;


            }

            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0L;
            }


        }
    }

    private void update() {


    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);


    }

}
