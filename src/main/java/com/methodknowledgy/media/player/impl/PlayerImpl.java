package com.methodknowledgy.media.player.impl;

import com.methodknowledgy.media.playable.Playable;
import com.methodknowledgy.media.player.Player;

public class PlayerImpl implements Player {

    private Playable playable;

    public Playable getCurrent() {
        return playable;
    }

    public RepeatMode getRepeatMode() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isRandom() {
        // TODO Auto-generated method stub
        return false;
    }

    public void load(Playable playable) {
        // TODO Auto-generated method stub
    }

    public void setRandom(boolean random) {
        // TODO Auto-generated method stub

    }

    public void setRepeatMode(RepeatMode mode) {
        // TODO Auto-generated method stub

    }

    public void unload() {
        // TODO Auto-generated method stub

    }

}
