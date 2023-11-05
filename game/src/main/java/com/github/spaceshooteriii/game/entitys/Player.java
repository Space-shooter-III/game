package com.github.spaceshooteriii.game.entitys;

import com.github.spaceshooteriii.game.Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Player extends ImageEntity {

    private int deg = 0;

    public Player(float x, float y, int width, int height) {
        super(x, y, 0f, 0f, width, height, EntityType.PLAYER, Game.TEXTRA_ALICE.getImageFrom(0, 16, 16, 16));
    }


    @Override
    public void draw(Graphics2D g2d) {

        AffineTransform oldXForm = g2d.getTransform();

        g2d.setColor(Color.BLUE);
        g2d.rotate(Math.toRadians(this.deg), (int) this.x + this.width / 2, (int) this.y + this.height / 2);
        super.draw(g2d);

        g2d.setTransform(oldXForm);

    }

    @Override
    public void update() {
        deg++;
        if (deg > 360) {
            deg = 0;
        }
    }
}
