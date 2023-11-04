package com.github.spaceshooteriii.game.state;

import com.github.spaceshooteriii.game.Drawable;
import com.github.spaceshooteriii.game.Updatable;
import com.github.spaceshooteriii.game.state.data.GameStateClassicManager;
import com.github.spaceshooteriii.game.state.data.GameStateHomeManager;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.awt.Graphics2D;

public class GameState implements Drawable, Updatable {

    private @Getter @Setter @NonNull GameMode mode;
    private @Getter @Setter @NonNull GameStateModeManager gameStateModeManager;

    public GameState() {
        this.mode = GameMode.HOME_SCREEN;
        this.gameStateModeManager = new GameStateHomeManager();
        this.gameStateModeManager.init();
    }

    @Override
    public void draw(Graphics2D g2d) {
        this.gameStateModeManager.draw(g2d);
    }

    @Override
    public void update() {
        this.gameStateModeManager.update();
    }
}
