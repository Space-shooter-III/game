package com.github.spaceshooteriii.game.state.data;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.state.GameMode;
import com.github.spaceshooteriii.game.state.GameStateModeManager;
import com.github.spaceshooteriii.game.textures.BufferedImageLoader;
import com.github.spaceshooteriii.game.textures.TextraAlice;
import lombok.Getter;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

public class GameStateLoadingManager extends GameStateModeManager {

    private class LoadingThread implements Runnable {
        private @Getter boolean loading;

        public LoadingThread() {
            this.loading = true;
        }

        @Override
        public void run() {
            // Load files
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.loading = false;
        }
    }


    private BufferedImage skyImage;
    private LoadingThread loadingThread;

    @Override
    public void draw(Graphics2D g2d) {

        // Draw background

        int x = 0;
        int y = 0;
        final int size = 64;

        for (int i = 0; i < Math.ceil((double) Game.HEIGHT / size) + 1; i++) {
            for (int j = 0; j < Math.ceil((double) Game.HEIGHT / size) + 1; j++) {
                g2d.drawImage(this.skyImage, x, y, size, size, null);
                x += size;
            }
            y += size;
            x = 0;
        }

    }

    @Override
    public void update() {

        if (!this.loadingThread.isLoading()) {
            Game.getState().switchMode(GameMode.HOME_SCREEN);
        }

    }

    @Override
    public void init() {
        Game.TEXTRA_ALICE_LOADER = new BufferedImageLoader("/assets/images/textra-alice.png");
        Game.TEXTRA_ALICE = new TextraAlice(Game.TEXTRA_ALICE_LOADER.getImage());

        this.skyImage = Game.TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);

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
