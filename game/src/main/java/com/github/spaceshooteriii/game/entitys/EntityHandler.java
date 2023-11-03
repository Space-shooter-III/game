package com.github.spaceshooteriii.game.entitys;

import com.github.spaceshooteriii.game.Drawable;
import com.github.spaceshooteriii.game.Updatable;
import lombok.Getter;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class EntityHandler implements Updatable, Drawable {

    private @Getter LinkedList<Entity> list;

    public EntityHandler() {
        this.list = new LinkedList<Entity>();
    }


    public void add(Entity e) {
        this.list.add(e);
    }

    public void remove(Entity e) {
        this.list.remove(e);
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (int i = 0; i < this.list.size(); i++) {
            Entity e = (Entity) this.list.get(i);
            e.draw(g2d);
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < this.list.size(); i++) {
            Entity e = (Entity) this.list.get(i);
            e.update();
        }
    }
}
