package com.github.spaceshooteriii.game.state.data;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.state.GameMode;
import com.github.spaceshooteriii.game.state.GameStateModeManager;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

public class GameStateHomeManager extends GameStateModeManager {

    private BufferedImage skyImage;
    private BufferedImage titleImage;
    private BufferedImage playButtonImage;
    private BufferedImage activePlayButtonImage;
    private BufferedImage quitButtonImage;
    private BufferedImage activeQuitButtonImage;

    private boolean playButtonActive;
    private boolean activeQuitButton;

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

        // Draw title

        g2d.drawImage(this.titleImage, ((Game.WIDTH / 2) - (96 * 6) / 2), 16, 96 * 6, 32 * 6, null);

        // Draw buttons

        if (this.playButtonActive) {
            g2d.drawImage(this.activePlayButtonImage, ((Game.WIDTH / 2) - (64 * 4) / 2), Game.HEIGHT / 3 * 2 - 16 * 4, 64 * 4, 16 * 4, null);
        } else {
            g2d.drawImage(this.playButtonImage, ((Game.WIDTH / 2) - (64 * 4) / 2), Game.HEIGHT / 3 * 2 - 16 * 4, 64 * 4, 16 * 4, null);
        }

        if (this.activeQuitButton) {
            g2d.drawImage(this.activeQuitButtonImage, 16, 16, 48, 48, null);
        } else {
            g2d.drawImage(this.quitButtonImage, 16, 16, 48, 48, null);
        }

    }

    @Override
    public void update() {

    }

    @Override
    public String save() {
        return null;
    }

    @Override
    public void load(String data) {

    }

    @Override
    public void init() {
        this.skyImage = Game.TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);
        this.titleImage = Game.TEXTRA_ALICE.getImageFrom(16, 0, 96, 32);
        this.playButtonImage = Game.TEXTRA_ALICE.getImageFrom(112, 0, 64, 16);
        this.activePlayButtonImage = Game.TEXTRA_ALICE.getImageFrom(112, 16, 64, 16);
        this.quitButtonImage = Game.TEXTRA_ALICE.getImageFrom(176, 0, 16, 16);
        this.activeQuitButtonImage = Game.TEXTRA_ALICE.getImageFrom(192, 0, 16, 16);

        this.playButtonActive = false;

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
        Rectangle playButtonBox = new Rectangle(((Game.WIDTH / 2) - (64 * 4) / 2), Game.HEIGHT / 3 * 2 - 16 * 4, 64 * 4, 16 * 4);

        if (playButtonBox.contains(e.getX(), e.getY())) {
            Game.getState().switchMode(GameMode.PLAYING_CLASSIC);
        }

        Rectangle quitButtonBox = new Rectangle(16, 16, 48, 48);

        if (quitButtonBox.contains(e.getX(), e.getY())) {
            System.exit(0);
        }

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
        Rectangle playButtonBox = new Rectangle(((Game.WIDTH / 2) - (64 * 4) / 2), Game.HEIGHT / 3 * 2 - 16 * 4, 64 * 4, 16 * 4);

        this.playButtonActive = playButtonBox.contains(e.getX(), e.getY());

        Rectangle quitButtonBox = new Rectangle(16, 16, 48, 48);

        this.activeQuitButton = quitButtonBox.contains(e.getX(), e.getY());

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
