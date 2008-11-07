package com.methodknowledgy.media.player;

/**
 * <p>
 * The Transport interface defines how a Player can control the Playable items
 * it currently owns. This works much the way a remote control works for a DVD
 * player, offering user-initiated control (where supported) of playback and
 * transport controls.
 * </p>
 * 
 * <p>
 * Because not all Players and Playables will support every method of transport,
 * control is generally expressed here as a Double that implies the rate of
 * playback. Special meaning is given to some valules, but the interpretation of
 * a transport rate is otherwise left to the implementation classes.
 * </p>
 * 
 * @author jcarlson
 * 
 */
public interface Transport {

	/**
	 * A transport rate of 0.0 implies that playback is paused or suspended.
	 */
	static final Double PAUSE = 0.0;

	/**
	 * A transport rate of 1.0 implies that the Playable is progressing linearly
	 * in a forward direction at its native rate.
	 */
	static final Double PLAY = 1.0;

	/**
	 * A transport rate of -1.0 implies that the Playable is progressing
	 * linearly in a reverse direction at its native rate.
	 */
	static final Double REVERSE = -1.0;

	/**
	 * A transport rate does is not valid if the Player is stopped, or not
	 * currently running. This case is expressed by the special value NaN, which
	 * differs from null (which indicates that a transport rate cannot be
	 * determined).
	 */
	static final Double STOP = Double.NaN;

	/**
	 * Interpretations about the capabilities of a given Transport
	 * implementation would normally define the maximum rate at which Playable
	 * can be transported. However, to represent this variable "max value" for
	 * all implementations, infinity is used instead.
	 */
	static final Double MAX_FF = Double.POSITIVE_INFINITY;

	/**
	 * Interpretations about the capabilities of a given Transport
	 * implementation would normally define the maximum rate at which Playable
	 * can be transported. However, to represent this variable "max value" for
	 * all implementations, negative infinity is used instead.
	 */
	static final Double MAX_RW = Double.NEGATIVE_INFINITY;

	/**
	 * Set the desired transport rate.
	 * 
	 * @param rate
	 */
	void transport(Double rate);

	/**
	 * Ask the Player to skip to the next Playable (if there is one).
	 * Functionality depends on the current Playable as well as the current
	 * Player. Some Playables may not allow themselves to be skipped.
	 */
	void next();

	/**
	 * Ask the Player to skip to the last Playable (if it is not the current
	 * one). Functionality depends on the current Playable as well as the
	 * current Player. Some Playables may not allow themselves to be skipped.
	 */
	void last();

	/**
	 * Ask the Player to skip to the previous Playable (if there is one).
	 * Functionality depends on the current Playable as well as the current
	 * Player. Some Playables may not allow themselves to be skipped.
	 */
	void previous();

	/**
	 * Ask the Player to skip to the first Playable (if there is one).
	 * Functionality depends on the current Playable as well as the current
	 * Player. Some Playables may not allow themselves to be skipped.
	 */
	void first();

}
