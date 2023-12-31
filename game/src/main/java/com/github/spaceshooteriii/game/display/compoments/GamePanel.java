package com.github.spaceshooteriii.game.display.compoments;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.event.listeners.KeyBoardEventListener;
import com.github.spaceshooteriii.game.event.listeners.MouseEventListener;
import com.github.spaceshooteriii.game.event.listeners.MouseMotionEventListener;
import com.github.spaceshooteriii.game.event.listeners.MouseWheelEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;
    private final int FPS;

    private KeyBoardEventListener keyListener;
    private MouseEventListener mouseListener;
    private MouseMotionEventListener mouseMotionListener;
    private MouseWheelEventListener mouseWheelListener;


    private static Logger LOGGER = LogManager.getLogger("GamePanel");

    public GamePanel() {

        this.keyListener = new KeyBoardEventListener();
        this.mouseListener = new MouseEventListener();
        this.mouseMotionListener = new MouseMotionEventListener();
        this.mouseWheelListener = new MouseWheelEventListener();

        GamePanel.LOGGER.info("Created GamePanel class");

        this.FPS = 60;

        this.addKeyListener(this.keyListener);
        this.addMouseListener(this.mouseListener);
        this.addMouseMotionListener(this.mouseMotionListener);
        this.addMouseWheelListener(this.mouseWheelListener);

        this.setDoubleBuffered(true);
    }

    public void startGameLoop() {
        this.gameThread = new Thread(this);
        this.gameThread.setDaemon(false);
        this.gameThread.setName("game-thread");
        GamePanel.LOGGER.info("Starting game thread");
        this.gameThread.start();
    }


    @Override
    public void run() {
        GamePanel.LOGGER.info("Started game thread");

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
        Game.getState().update();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        Game.getState().draw(g2d);

    }

}
