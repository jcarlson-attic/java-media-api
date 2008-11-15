package com.methodknowledgy.media.events;

public interface Action {

	<T> void execute(T Source, Event event);
	
}
