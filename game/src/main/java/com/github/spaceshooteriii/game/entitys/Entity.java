package com.github.spaceshooteriii.game.entitys;

import com.github.spaceshooteriii.game.Drawable;
import com.github.spaceshooteriii.game.Updatable;
import lombok.Data;

import java.awt.Rectangle;

@Data
public abstract class Entity implements Drawable, Updatable {

    protected float x;
    protected float y;
    protected float xv;
    protected float yv;

    protected int width;
    protected int height;

    protected EntityType id;

    public Entity(float x, float y, float xv, float yv, int width, int height, EntityType id) {
        this.x = x;
        this.y = y;
        this.xv = xv;
        this.yv = yv;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public Rectangle getRectangle() {
        return new Rectangle((int) this.x, (int) this.y, this.width, this.height);
    }

}
