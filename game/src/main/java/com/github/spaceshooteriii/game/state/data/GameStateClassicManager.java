package com.github.spaceshooteriii.game.state.data;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.entitys.EntityHandler;
import com.github.spaceshooteriii.game.entitys.Player;
import com.github.spaceshooteriii.game.state.GameMode;
import com.github.spaceshooteriii.game.state.GameStateModeManager;
import lombok.Getter;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

public class GameStateClassicManager extends GameStateModeManager {

    private @Getter EntityHandler entityHandler;
    private BufferedImage skyImage;

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
    }

    @Override
    public void update() {
        this.entityHandler.update();
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
        this.entityHandler.add(new Player((float) Game.WIDTH / 2 - 32, (float) Game.WIDTH / 2 - 32, 64, 64));

        this.skyImage = Game.TEXTRA_ALICE.getImageFrom(0, 0, 16, 16);

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
        // ! TESTING CODE START

        Game.getState().switchMode(GameMode.HOME_SCREEN);

        // ! TESTING CODE END
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
