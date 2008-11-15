package com.methodknowledgy.media.events;

public interface EventDispatcher {

	void register(Subscription subscription);
	
	void unregister(Subscription subscription);
	
	<T> void dispatch(T source, Event event);

}
