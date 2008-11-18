package com.methodknowledgy.media.playable.impl;

import java.util.Collection;
import java.util.List;
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
    
    
    
    
    

    @Override
    public synchronized boolean add(Playable o) {
        // TODO Auto-generated method stub
        return super.add(o);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Playable> c) {
        // TODO Auto-generated method stub
        return super.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index,
            Collection<? extends Playable> c) {
        // TODO Auto-generated method stub
        return super.addAll(index, c);
    }

    @Override
    public synchronized void addElement(Playable obj) {
        // TODO Auto-generated method stub
        super.addElement(obj);
    }

    @Override
    public synchronized void insertElementAt(Playable obj, int index) {
        // TODO Auto-generated method stub
        super.insertElementAt(obj, index);
    }

    @Override
    public synchronized Playable remove(int index) {
        // TODO Auto-generated method stub
        return super.remove(index);
    }

    @Override
    public synchronized void removeAllElements() {
        // TODO Auto-generated method stub
        super.removeAllElements();
    }

    @Override
    public synchronized void removeElementAt(int index) {
        // TODO Auto-generated method stub
        super.removeElementAt(index);
    }

    @Override
    protected synchronized void removeRange(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        super.removeRange(fromIndex, toIndex);
    }

    @Override
    public synchronized Playable set(int index, Playable element) {
        // TODO Auto-generated method stub
        return super.set(index, element);
    }

    @Override
    public synchronized void setElementAt(Playable obj, int index) {
        // TODO Auto-generated method stub
        super.setElementAt(obj, index);
    }

    @Override
    public synchronized void setSize(int newSize) {
        // TODO Auto-generated method stub
        super.setSize(newSize);
    }

    @Override
    public synchronized List<Playable> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return super.subList(fromIndex, toIndex);
    }


    
    
    

}
