package com.github.spaceshooteriii.game.event.listeners;

import com.github.spaceshooteriii.game.Game;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelEventListener implements MouseWheelListener {
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        Game.getState().getGameStateModeManager().mouseWheelMoved(e);
    }
}
