package com.github.spaceshooteriii.game.state.data;

import com.github.spaceshooteriii.game.Game;
import com.github.spaceshooteriii.game.state.GameStateModeManager;

import java.awt.Color;
import java.awt.Graphics2D;

public class GameStateHomeManager extends GameStateModeManager {

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.drawString("Hello, world!", Game.WIDTH/2, Game.HEIGHT/2);
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


    }
}
