package com.methodknowledgy.media.events;

public interface Event<SourceType> {
	
	SourceType getSource();
	
}
