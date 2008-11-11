package com.methodknowledgy.media.player;

import com.methodknowledgy.media.events.Event;
import com.methodknowledgy.media.events.EventDispatcher;

public interface PlayerEventDispatcher extends EventDispatcher {

	void onLoad();
	
	public enum PlayerEvent implements Event {
		LOAD, UNLOAD, RANDOM_MODE_CHANGE, REPEAT_MODE_CHANGE
	}
	
}
