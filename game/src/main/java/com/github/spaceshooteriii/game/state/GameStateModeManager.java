package com.github.spaceshooteriii.game.state;

import com.github.spaceshooteriii.game.Drawable;
import com.github.spaceshooteriii.game.Updatable;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public abstract class GameStateModeManager implements Drawable, Updatable, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    public abstract void init();
    public abstract String save();
    public abstract void load(String data);

}
