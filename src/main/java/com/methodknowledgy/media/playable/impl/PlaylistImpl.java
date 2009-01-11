package com.methodknowledgy.media.playable.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.methodknowledgy.media.playable.Playable;
import com.methodknowledgy.media.playable.Playlist;
import com.methodknowledgy.media.playable.Segment;
import com.methodknowledgy.media.rendering.Renderer;

public class PlaylistImpl extends Vector<Playable> implements Playlist {

    private static final long serialVersionUID = 1L;
    private int index = -1;
    private boolean autoAdvance;
    
    public void initialize() {
    }

    public boolean getAutoAdvance() {
        return autoAdvance;
    }

    public boolean hasCurrent() {
        return index > -1;
    }

    public Playable current() {
        if (hasCurrent()) {
            return get(index);
        }
        return null;
    }

    public Integer currentIndex() {
        if (hasCurrent()) {
            return index;
        }
        return null;
    }

    public boolean hasNext() {
        return hasCurrent() && size() > index + 1;
    }

    public boolean hasPrevious() {
        return index > 0;
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

    public Playable jumpTo(int index) throws ArrayIndexOutOfBoundsException {
        Playable p = get(index);
        this.index = index;
        return p;
    }

    public void setIndex(int index) {
        if (index < -1 || index > size() - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.index = index;
    }

    public Map<String, String> getAttributes() {
        // TODO Auto-generated method stub
        return null;
    }

    public Renderer getRenderer() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getRunTime() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Segment> getSegments() {
        // TODO Auto-generated method stub
        return null;
    }

    public State getState() {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean isActive() {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean isScrubbable() {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean isSkippable() {
        // TODO Auto-generated method stub
        return null;
    }

    public void render() {
        // TODO Auto-generated method stub

    }

    @Override
    public synchronized boolean add(Playable o) {
        if (!hasCurrent()) {
            index++;
        }
        return super.add(o);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Playable> c) {
        if (!hasCurrent()) {
            index++;
        }
        return super.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index,
            Collection<? extends Playable> c) {
        boolean b = super.addAll(index, c);
        if (b && this.index < 0) {
            // the list was previously empty
            this.index = 0;
        } else if (b && index < this.index) {
            // the items were inserted before the current index
            this.index += c.size();
        } else if (b && index == this.index) {
            // the items were inserted at the current index
            // do nothing - the first item of the inserted set becomes the
            // current item
        }
        return b;
    }

    @Override
    public synchronized void addElement(Playable obj) {
        if (!hasCurrent()) {
            index++;
        }
        super.addElement(obj);
    }

    @Override
    public synchronized void insertElementAt(Playable obj, int index) {
        if (this.index < 0) {
            this.index = 0;
        }
        else if (index < this.index) {
            // the item was inserted before the current index
            this.index++;
        }
        else if (index == this.index) {
            // the item was inserted at the current index
            // do nothing - the first item of the inserted set becomes the
            // current item
        }
        super.insertElementAt(obj, index);
    }

    @Override
    public synchronized Playable remove(int index) {
        Playable p = super.remove(index);
        updateIndex(index);
        return p;
    }

    @Override
    public synchronized void removeAllElements() {
        super.removeAllElements();
        index = -1;
    }

    @Override
    public synchronized void removeElementAt(int index) {
        super.removeElementAt(index);
        updateIndex(index);
    }

    @Override
    protected synchronized void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
        updateIndex(fromIndex, toIndex);
    }

    @Override
    public synchronized void setSize(int newSize) {
        int size = size();
        super.setSize(newSize);
        // TODO - This isn't correct
        updateIndex(newSize, size);
    }
    
    

    private void updateIndex(int removedIndex) {
        if ((removedIndex <= index)) {
            // removed item is at or before the index, so the index likely needs
            // to shift to account for it
            if (size() == 0) {
                // the removed item was the only item, no items remain
                index = -1;
            } else if (index > 0) {
                // the removal occurred somewhere before the index
                index--;
            }
            // if removedIndex == 0 and index == 0
            // do nothing - index remains the same
        }
    }

    private void updateIndex(int fromIndex, int toIndex) {
        if (index < fromIndex) {
            // entire range is greater than current index
            // do nothing
        } else if (index >= toIndex) {
            // entire range is less than index
            index = index - (toIndex - fromIndex);
        } else if (index >= fromIndex && index < toIndex && fromIndex < toIndex
                && index > 0) {
            // index is in removal range, but previous items exist
            index = fromIndex - 1;
        } else if (index >= fromIndex && index < toIndex && fromIndex < toIndex
                && index == 0 && size() > 0) {
            // index is in removal range, previous items do not exist, but next
            // items do and index is 0
            // do nothing
        } else if (index >= fromIndex && index < toIndex && fromIndex == 0
                && size() > 0) {
            // index is in removal range, previous items do not exist, but more
            // items do and index is not 0
            index = 0;
        } else if (size() == 0) {
            // there no items left after the removal operation
            // index is in removal range, but there are no previous or more
            // items
            index = -1;
        }
    }

}
