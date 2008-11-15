package com.methodknowledgy.media.events;

public interface Event<SourceType> {
	
	EventType getEventType();
	
	SourceType getSource();
	
}
