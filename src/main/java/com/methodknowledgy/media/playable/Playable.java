package com.methodknowledgy.media.playable;

import java.util.Map;

public interface Playable {

    /**
     * Indicates if this Playable is viewable by the user. A Playable may become
     * inactive if it is hidden from view, such as during a Play Chain
     * Injection, or an advertisement overlay.
     * 
     * @return True if the Playable is active. False if it is not active. Null
     *         if this information cannot be determined.
     */
    Boolean isActive();

    Boolean isScrubbable();

    Boolean isSkippable();

    /**
     * @return The total run time of this Playable, in seconds. Run time is
     *         <code>null</code> if the duration cannot be determined or is
     *         indefinite.
     */
    Long getRunTime();

    /**
     * @return An extended list of attributes for this Playable object.
     */
    Map<String, String> getAttributes();

    /**
     * State information should generally be gathered from the Player object
     * handling a Video, as more detailed information, such as buffering
     * percentage or play head location, can be obtained. The sate is provided
     * here merely as a convenience.
     * 
     * @return The current State of this Playable.
     */
    State getState();

    /**
     * Describes the current state of this Playable object.
     * 
     * <ul>
     * <li><strong>LOADING:</strong> This Playable is currently loading the
     * necessary assets.</li>
     * <li><strong>READY:</strong> This Playable is currently ready to be
     * played.</li>
     * <li><strong>RUNNING:</strong> This Playable is currently progressing
     * along its duration.</li>
     * <li><strong>SUSPENDED:</strong> This Playable was running but has been
     * temporarily suspended. Not all Playable objects support the SUSPENDED
     * State, but those that do can be resumed from the point at which they were
     * suspended.</li>
     * <li><strong>STOPPED:</strong> This Playable has been stopped by the
     * user. Resuming a STOPPED Playable generally results in a restart of the
     * Playable from the beginning.</li>
     * <li><strong>COMPLETED:</strong> This Playable has naturally reached its
     * end. Resuming a COMPLETED Playable always results in a restart of the
     * Playable from the beginning.</li>
     * </ul>
     * 
     * @author jcarlson
     * 
     */
    public enum State {
        LOADING, READY, RUNNING, SUSPENDED, STOPPED, FINISHED
    }

}
