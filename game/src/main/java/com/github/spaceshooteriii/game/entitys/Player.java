package com.github.spaceshooteriii.game.entitys;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.state.data.GameStateClassicManager;
import lombok.Getter;
import lombok.Setter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Player extends ImageEntity {

    public static final float SLOW_BY = 0.01f;

    private @Setter @Getter int mouseX;
    private @Setter @Getter int mouseY;

    private int deg = 0;

    public Player(float x, float y, int width, int height) {
        super(x, y, 0f, 0f, width, height, EntityType.PLAYER, Game.TEXTRA_ALICE.getImageFrom(0, 16, 16, 16));
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
//        this.deg++;
//        if (this.deg > 360) {
//            this.deg = 0;
//        }

        this.x += this.xv;
        this.y += this.yv;

        this.x = Game.clamp(this.x, (float) (Game.WIDTH - this.width), 0f);
        this.y = Game.clamp(this.y, (float) (Game.HEIGHT - (float) (this.height * 1.3f)), 0f);

        this.deg = (int) Math.toDegrees(Math.atan2(this.mouseX - (this.x + ((double) this.width / 2)), -(this.mouseY - this.y)));

    }

    public void shot() {
        if (Game.getState().getGameStateModeManager() instanceof GameStateClassicManager) {

            float[] vs = Game.calculateDirection(this.mouseX, this.mouseY, 4f, this.x + this.width / 2, this.y + this.height / 2);

            ((GameStateClassicManager) Game.getState().getGameStateModeManager())
                    .getEntityHandler()
                    .add(new Bullet(this.x + this.width / 2, this.y + this.height / 2, vs[0], vs[1], 32, 32, this.deg));
        }
    }

}
