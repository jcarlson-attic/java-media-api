package com.methodknowledgy.media.events;

public interface EventDispatcher {

	void registerAction(Action action);
	
	void registerAction(Class<Event> event, Action action);
	
	void registerAction(Object generator, Action action);
	
	void registerAction(Object generator, Event event, Action action);
	
	void unregisterAction(Action action);
	
	void unregisterAction(Object generator, Action action);
	
	void unregisterAction(Object generator, Event event, Action action);

	void unregisterAction(Event event, Action action);
	
}
