package com.github.spaceshooteriii.game.event.listeners;

import com.github.spaceshooteriii.game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardEventListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        Game.getState().getGameStateModeManager().keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Game.getState().getGameStateModeManager().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Game.getState().getGameStateModeManager().keyReleased(e);
    }
}
