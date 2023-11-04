package com.github.spaceshooteriii.game.state.data;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.entitys.EntityHandler;
import com.github.spaceshooteriii.game.entitys.Player;
import com.github.spaceshooteriii.game.state.GameStateModeManager;
import lombok.Getter;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class GameStateClassicManager extends GameStateModeManager {

    private @Getter EntityHandler entityHandler;

    @Override
    public void draw(Graphics2D g2d) {
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
}
