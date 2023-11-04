package com.github.spaceshooteriii.game.event.listeners;

import com.github.spaceshooteriii.game.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionEventListener implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        Game.getState().getGameStateModeManager().mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Game.getState().getGameStateModeManager().mouseMoved(e);
    }
}
