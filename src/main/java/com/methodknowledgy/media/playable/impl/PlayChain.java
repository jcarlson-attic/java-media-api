package com.methodknowledgy.media.playable.impl;

import com.methodknowledgy.media.playable.Playable;

/**
 * <p>
 * A PlayChain is essentially a complex Playable. Whereas a Playable is a single
 * (and most indivisible unit of structure), a PlayChain acts like a Playable
 * and is identified as a Playable, but is in fact as wrapper of one or more
 * Playables.
 * </p>
 * 
 * <p>
 * Although similar in function to a Playlist, a PlayChain is generally
 * content-controlled and does not afford the end-user granular control over the
 * Playables it wraps (whereas a Playlist is typically user-controlled).
 * </p>
 * 
 * <p>
 * Because of the similarities with a Playlist, however, most of the PlayChain's
 * functionality is derived directly from a Playlist, which is used internally
 * to manage the chain.
 * </p>
 * 
 * @author jcarlson
 * 
 */
public abstract class PlayChain implements Playable {

}
