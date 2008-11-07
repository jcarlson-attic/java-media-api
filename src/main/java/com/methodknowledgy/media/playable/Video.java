package com.methodknowledgy.media.playable;

import java.net.URL;

import com.methodknowledgy.media.player.Player;

/**
 * <p>
 * Represents a single video object. A video is the simplest level of
 * abstraction that can be played by a Player.
 * </p>
 * <p>
 * A Video object itself is not capable of taking any action. Much like a DVD is
 * useless without a DVD Player, a Video object relies on a Player instance in
 * order to view the video.
 * </p>
 * 
 * 
 * @author jcarlson
 * @see Player
 * 
 */
public interface Video extends Playable {

	/**
	 * @return The URL where this video can be found.
	 */
	URL getURL();

	/**
	 * PlayState is a more granular indication of the current State of
	 * a Video object. PlayState encompasses states specific to Video objects,
	 * such as BUFFERING.
	 * 
	 * @return The current PlayState of this Video.
	 */
	PlayState getPlayState();

	/**
	 * Describes the current state of this Video object.
	 * 
	 * <ul>
	 * <li><strong>IDLE:</strong> This video has not begun buffering (if
	 * necessary).</li>
	 * <li><strong>BUFFERING:</strong> This video is currently performing
	 * initial buffering. Occurs only once per run.</li>
	 * <li><strong>READY:</strong> This video has completed initial buffering
	 * and is ready to begin playing.</li>
	 * <li><strong>PLAYING:</strong> This video is currently playing.</li>
	 * <li><strong>REBUFFERING:</strong> This video has been suspended while
	 * rebuffering occurs, usually due to network congestion.</li>
	 * <li><strong>RW_SCRUBBING:</strong> This video is scrubbing backwards
	 * (if supported). This state includes any rebuffering necessary, since it
	 * is generally a user-initiated action.</li>
	 * <li><strong>FF_SCRUBBING:</strong> This video is scrubbing forwards (if
	 * supported). This state includes any rebuffering necessary, since it is
	 * generally a user-initiated action.</li>
	 * <li><strong>PAUSED:</strong> This video is currently suspended. Play
	 * can resume where it left off.</li>
	 * <li><strong>STOPPED:</strong> This video has been stopped before
	 * reaching the end. This is generally a user-initiated state. Play
	 * generally resumes from the beginning in this case.</li>
	 * <li><strong>FINISHED:</strong> This video has reached its natural end
	 * point. Play always restarts from the beginning after reaching a FINISHED
	 * state.</li>
	 * </ul>
	 * 
	 * @author jcarlson
	 * 
	 */
	public enum PlayState {
		IDLE, BUFFERING, READY, PLAYING, REBUFFERING, RW_SCRUBBING, FF_SCRUBBING, PAUSED, STOPPED, FINISHED
	}
}
