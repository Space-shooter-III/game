package com.github.spaceshooteriii.game.state.data;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.entitys.Entity;
import com.github.spaceshooteriii.game.entitys.EntityHandler;
import com.github.spaceshooteriii.game.entitys.Player;
import com.github.spaceshooteriii.game.state.GameMode;
import com.github.spaceshooteriii.game.state.GameStateModeManager;
import lombok.Getter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

public class GameStateClassicManager extends GameStateModeManager {

    private @Getter EntityHandler entityHandler;
    private BufferedImage skyImage;

    private BufferedImage backButtonImage;
    private BufferedImage activeBackButtonImage;

    private boolean backButtonActive;

    private @Getter Player player;

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

        this.entityHandler.draw(g2d);

        this.player.draw(g2d);

        if (this.backButtonActive) {
            g2d.drawImage(this.activeBackButtonImage, 16, 16, 48, 48, null);
        } else {
            g2d.drawImage(this.backButtonImage, 16, 16, 48, 48, null);
        }

    }

    @Override
    public void update() {
        this.entityHandler.update();

        this.player.update();
    }

    @Override
    public String save() {
        return "{}";
    }

    @Override
    public void load(String data) {}

    @Override
    public void init() {
        this.entityHandler = new EntityHandler();
        this.player = new Player((float) Game.WIDTH / 2 - 32, (float) Game.WIDTH / 2 - 32, 64, 64);

        this.backButtonImage = Game.TEXTRA_ALICE.getImageFrom(176, 16, 16, 16);
        this.activeBackButtonImage = Game.TEXTRA_ALICE.getImageFrom(192, 16, 16, 16);

        this.skyImage = Game.TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);

        this.backButtonActive = false;

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
        Rectangle backButtonBox = new Rectangle(16, 16, 48, 48);

        if (backButtonBox.contains(e.getX(), e.getY())) {
            Game.getState().switchMode(GameMode.HOME_SCREEN);
        }

        this.player.shot();

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

        Rectangle backButtonBox = new Rectangle(16, 16, 48, 48);

        this.backButtonActive = backButtonBox.contains(e.getX(), e.getY());

        this.player.setMouseX(e.getX());
        this.player.setMouseY(e.getY());

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
