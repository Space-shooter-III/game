package com.github.spaceshooteriii.game.entitys;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.state.data.GameStateClassicManager;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Bullet extends ImageEntity {

    private @Getter @Setter int deg;

    public Bullet(float x, float y, float xv, float yv, int width, int height, int deg) {
        super(x, y, xv, yv, width, height, EntityType.BULLET, Game.TEXTRA_ALICE.getImageFrom(208, 0, 16, 16));
        this.deg = deg;
    }

    @Override
    public void draw(Graphics2D g2d) {

        AffineTransform oldXForm = g2d.getTransform();

        g2d.rotate(Math.toRadians(this.deg), (int) this.x + this.width / 2, (int) this.y + this.height / 2);
        super.draw(g2d);

        g2d.setTransform(oldXForm);

    }

    @Override
    public void update() {

        this.x += this.xv;
        this.y += this.yv;


        if (this.x < 0 || this.y < 0 || this.x > Game.WIDTH || this.y > Game.HEIGHT) {
            if (Game.getState().getGameStateModeManager() instanceof GameStateClassicManager) {
                ((GameStateClassicManager) Game.getState().getGameStateModeManager()).getEntityHandler().remove(this);
            }
        }

    }
}
