package com.github.spaceshooteriii.game.event.listeners;

import com.github.spaceshooteriii.game.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        Game.getState().getGameStateModeManager().mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Game.getState().getGameStateModeManager().mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Game.getState().getGameStateModeManager().mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Game.getState().getGameStateModeManager().mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Game.getState().getGameStateModeManager().mouseExited(e);
    }
}
