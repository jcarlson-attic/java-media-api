package com.methodknowledgy.media.events;

public interface Action {

	<T> void execute(T source, Event event);
	
}
