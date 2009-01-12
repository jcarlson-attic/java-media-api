package com.methodknowledgy.media.player.impl;

import com.methodknowledgy.events.dispatch.EventDispatcher;
import com.methodknowledgy.events.impl.ChangeEvent;
import com.methodknowledgy.media.playable.Playable;
import com.methodknowledgy.media.player.Player;

public class BasicPlayer implements Player {

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
        // TODO: If the event is distributed before the Playable is finished
        // LOADING, it may not be complete when subscribers try to access it.
        // Conversely, if we wait for the Playable to load, we may cause thread
        // locks.
        ChangeEvent<Player, Playable> event = new ChangeEvent<Player, Playable>(
                this, "playable", this.playable, this.playable = playable);
        EventDispatcher.getInstance().dispatch(event);
        playable.initialize();
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
