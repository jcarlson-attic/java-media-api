package com.methodknowledgy.media.events;

public interface Action {

	<E extends Event<?>> void execute(E event);
	
}
