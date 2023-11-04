package com.github.spaceshooteriii.game.state;

import com.github.spaceshooteriii.game.Drawable;
import com.github.spaceshooteriii.game.Updatable;
import com.github.spaceshooteriii.game.state.data.GameStateClassicManager;
import com.github.spaceshooteriii.game.state.data.GameStateHomeManager;
import com.github.spaceshooteriii.game.state.data.GameStateLoadingManager;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Graphics2D;

public class GameState implements Drawable, Updatable {

    private @Getter @Setter @NonNull GameMode mode;
    private @Getter @Setter @NonNull GameStateModeManager gameStateModeManager;

    private static Logger LOGGER = LogManager.getLogger("GameState");

    public GameState() {
        this.mode = GameMode.LOADING_SCREEN;
        this.gameStateModeManager = new GameStateLoadingManager();
        GameState.LOGGER.info("Running init for game mode: {}", this.mode);
        this.gameStateModeManager.init();
    }

    public void switchMode(GameMode mode) {

        GameState.LOGGER.info("Switching game modes: {}", mode);

        switch (mode) {
            case HOME_SCREEN:
                this.gameStateModeManager = new GameStateHomeManager();
                break;
            case PLAYING_CLASSIC:
                this.gameStateModeManager = new GameStateClassicManager();
                break;
            case LOADING_SCREEN:
                this.gameStateModeManager = new GameStateLoadingManager();
                break;
        }

        this.mode = mode;

        GameState.LOGGER.info("Running init for game mode: {}", this.mode);

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
