package com.methodknowledgy.media.events;

public interface EventDispatcher {

	void subscribe(Subscriber subscriber);
	
	void subscribe(Subscriber subscriber, Filter filter);
	
	void unsubscribe(Subscriber subscriber);
	
	void unsubscribe(Subscriber subscriber, Filter filter);
	
	void dispatch(Object source, Event event);

}
