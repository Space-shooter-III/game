package com.github.spaceshooteriii.game.state.data;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.state.GameStateModeManager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class GameStateHomeManager extends GameStateModeManager {

    private BufferedImage skyImage;

    @Override
    public void draw(Graphics2D g2d) {

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

    }
}
