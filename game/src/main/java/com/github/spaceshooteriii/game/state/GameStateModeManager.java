package com.github.spaceshooteriii.game.state;

import com.github.spaceshooteriii.game.Drawable;
import com.github.spaceshooteriii.game.Updatable;

import java.awt.event.KeyListener;

public abstract class GameStateModeManager implements Drawable, Updatable, KeyListener {

    public abstract void init();
    public abstract String save();
    public abstract void load(String data);

}
