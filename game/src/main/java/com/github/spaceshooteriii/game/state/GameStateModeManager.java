package com.github.spaceshooteriii.game.state;

import com.github.spaceshooteriii.game.Drawable;
import com.github.spaceshooteriii.game.Updatable;

public abstract class GameStateModeManager implements Drawable, Updatable {

    public abstract String save();
    public abstract void load(String data);

    public abstract void init();

}
