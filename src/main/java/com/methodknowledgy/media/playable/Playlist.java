package com.methodknowledgy.media.playable;

import java.util.List;


/**
 * Represents a Player-based playlist. Individual Playables may also be
 * pseudo-playlists (better known as a PlayChain). Playlists are generally user
 * constructed, rather than content-constructed. For example, a single Playable
 * may consist of a pre-roll, content, and post-roll. The entire PlayChain is
 * listed as one entry on the Playlist.
 * 
 * @author jcarlson
 * 
 */
public interface Playlist extends List<Playable>, Playable {

    boolean getAutoAdvance();
    
    boolean hasCurrent();

    Playable current();

    Integer currentIndex();
    

    boolean hasNext();
    
    Integer nextIndex();
    
    Playable next();
    

    boolean hasPrevious();

    Integer previousIndex();
    
    Playable previous();
    
    
    Playable jumpTo(int index);
    
}
