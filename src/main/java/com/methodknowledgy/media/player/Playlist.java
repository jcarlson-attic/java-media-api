package com.methodknowledgy.media.player;

import java.util.List;

import com.methodknowledgy.media.playable.Playable;

/**
 * Represents a Player-based playlist. Individual Playables may also be
 * pseudo-playlists (better known as a PlayChain). Playlists are genrally user
 * constructed, rather than content-constructed. For example, a single Playable
 * may consist of a pre-roll, content, and post-roll. The entire PlayChain is
 * listed as one entry on the Playlist.
 * 
 * @author jcarlson
 * 
 */
public interface Playlist extends List<Playable>, Playable {

	Playable getCurrent();
	
	Integer getPosition();
	
	Playable getNext();
	
	Playable getPrevious();
	
}
