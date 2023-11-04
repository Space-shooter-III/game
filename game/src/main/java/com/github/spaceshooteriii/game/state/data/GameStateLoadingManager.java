package com.github.spaceshooteriii.game.state.data;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.state.GameMode;
import com.github.spaceshooteriii.game.state.GameStateModeManager;
import com.github.spaceshooteriii.game.textures.BufferedImageLoader;
import com.github.spaceshooteriii.game.textures.TextraAlice;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

public class GameStateLoadingManager extends GameStateModeManager {

    private static Logger LOGGER = LogManager.getLogger("GameStateLoadingManager");

    private class LoadingThread implements Runnable {
        private @Getter boolean loading;

        private static Logger LOGGER = LogManager.getLogger("LoadingThread");

        public LoadingThread() {
            this.loading = true;
        }

        @Override
        public void run() {
            LoadingThread.LOGGER.info("Loading all assets");

            Game.TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/textra-alice.png");
            Game.TEXTRA_ALICE = new TextraAlice(Game.TEXTRA_ALICE_LOADER.getImage());

            GameStateLoadingManager.LOGGER.info("Loaded textra-alice");

            this.loading = false;
            LoadingThread.LOGGER.info("Loaded all assets");
        }
    }

    private LoadingThread loadingThread;

    @Override
    public void draw(Graphics2D g2d) {

        // Draw background

        g2d.setColor(new Color(0xf74040));
        g2d.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g2d.setFont(Game.GAME_FONT.deriveFont(Font.PLAIN, 50f));
        g2d.setColor(new Color(0xffffff));
        g2d.drawString("Loading...", Game.WIDTH / 2 - 100, Game.HEIGHT / 2);
        g2d.setFont(Game.GAME_FONT.deriveFont(Font.PLAIN, 25f));
        g2d.drawString("This should be fast", Game.WIDTH / 2 - 100, Game.HEIGHT / 2 + 50);

    }

    @Override
    public void update() {

        if (!this.loadingThread.isLoading()) {
            Game.getState().switchMode(GameMode.HOME_SCREEN);
        }

    }

    @Override
    public void init() {

        try {
            Game.GAME_FONT = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/assets/fonts/Roboto-Regular.ttf"));
        } catch (Exception e) {
            GameStateLoadingManager.LOGGER.error("Cannot load Roboto font failed with error: {}", "/assets/fonts/Roboto-Regular.ttf");
        }

        GameStateLoadingManager.LOGGER.info("Loaded Roboto font");

        this.loadingThread = new LoadingThread();

        Thread loaddingThread = new Thread(loadingThread);

        loaddingThread.setDaemon(false);
        loaddingThread.setName("loading-thread");

        loaddingThread.start();

    }

    @Override
    public String save() {
        return null;
    }

    @Override
    public void load(String data) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
