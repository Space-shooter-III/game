package com.github.spaceshooteriii.game.entitys;

import lombok.Getter;
import lombok.NonNull;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ImageEntity extends Entity {

    @NonNull
    @Getter
    protected BufferedImage image;

    public ImageEntity(float x, float y, float xv, float yv, int width, int height, EntityType id, BufferedImage image) {
        super(x, y, xv, yv, width, height, id);
        this.image = image;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(this.getImage(), (int) this.x, (int) this.y, this.width, this.height, null);
    }

}
