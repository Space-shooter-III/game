package com.github.spaceshooteriii.game.entitys;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Player extends Entity {

    private int deg = 0;

    public Player(float x, float y, int width, int height) {
        super(x, y, 0f, 0f, width, height, EntityType.PLAYER);
    }


    @Override
    public void draw(Graphics2D g2d) {

        AffineTransform oldXForm = g2d.getTransform();

        g2d.setColor(Color.BLUE);
        g2d.rotate(Math.toRadians(this.deg), (int) this.x + this.width / 2, (int) this.y + this.height / 2);
        g2d.fillRect((int) this.x, (int) this.y, this.width, this.height);

        g2d.setTransform(oldXForm);

        g2d.setColor(new Color(255, 0, 0, 128));
        g2d.fillRect((int) this.x, (int) this.y, this.width, this.height);

    }

    @Override
    public void update() {
        deg++;
        if (deg > 360) {
            deg = 0;
        }
    }
}
