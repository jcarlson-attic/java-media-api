package com.methodknowledgy.media.playable.impl;

import java.util.Vector;

import com.methodknowledgy.media.playable.Playable;
import com.methodknowledgy.media.playable.Playlist;

public abstract class PlaylistImpl extends Vector<Playable> implements Playlist {

	private static final long serialVersionUID = 1L;
	private int index = -1;
	private boolean autoAdvance;

    public boolean getAutoAdvance() {
        return autoAdvance;
    }

    public boolean hasCurrent() {
        return size() > 0 && index > -1;
    }
    
    public Playable current() {
        if (hasCurrent()) {
            return get(index);
        }
        return null;
    }

    public Integer currentIndex() {
        return index;
    }

    public boolean hasNext() {
        return hasCurrent() && size() > index + 1;
    }

    public boolean hasPrevious() {
        return hasCurrent() && index > 0;
    }

    public Playable next() {
        if (hasNext()) {
            return get(++index);
        }
        return null;
    }

    public Integer nextIndex() {
        if (hasNext()) {
            return index + 1;
        }
        return null;
    }

    public Playable previous() {
        if (hasPrevious()) {
            return get(--index);
        }
        return null;
    }

    public Integer previousIndex() {
        if (hasPrevious()) {
            return index - 1;
        }
        return null;
    }



}
