package com.methodknowledgy.media.events;

public interface Subscription {

	Filter getFilter();
	
	Action getAction();
	
	boolean isValidOnFilterAbstain();
	
	<E extends Event<?>> boolean isValidForEvent(E event);
	
	<E extends Event<?>> void executeIfValid(E event);
	
}
