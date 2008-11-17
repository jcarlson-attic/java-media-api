package com.methodknowledgy.media.player;

import com.methodknowledgy.media.playable.Playable;

/**
 * <p>
 * Players control the business logic of how media playback is presented to the
 * user. A Player generally has one Canvas to which it renders the Playables it
 * contains using the Playable's Renderer, however, there are exceptions.
 * </p>
 * 
 * <p>
 * A Player may work directly with either Playables (a single media item) or
 * Playlists (a set of media items). However, a Player typically only possesses
 * either a single Playlist or a single Playable at any given time. Some Player
 * implementations, however, may contradict this.
 * </p>
 * 
 * @author jcarlson
 * 
 */
public interface Player {
	
	Transport getTransport();
	
	Canvas getCanvas();

	Playable getCurrent();

	void load(Playable playable);

	void unload();

	/**
	 * Activate a repeat mode for this Player
	 * 
	 * @param loop
	 */
	void setRepeatMode(RepeatMode mode);

	/**
	 * @return The current RepeatMode
	 */
	RepeatMode getRepeatMode();

	/**
	 * Activates random shuffle for this Player.
	 * 
	 * @param random
	 *            True to enable random. False to disable random.
	 */
	void setRandom(boolean random);

	/**
	 * @return True if the Player is in random mode. False otherwise.
	 */
	boolean isRandom();

	public enum RepeatMode {
		OFF, CURRENT, ALL
	}

}
