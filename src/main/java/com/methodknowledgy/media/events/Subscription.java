package com.methodknowledgy.media.events;

public interface Subscription {

	Filter getFilter();
	
	Action getAction();
	
	boolean isValidOnFilterAbstain();
	
	<T> boolean isValidForEvent(T source, Event event);
	
	<T> void executeIfValid(T source, Event event);
	
}
