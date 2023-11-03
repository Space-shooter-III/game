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

    public Rectangle getRectangle() {
        return new Rectangle((int) this.x, (int) this.y, this.width, this.height);
    }

}
