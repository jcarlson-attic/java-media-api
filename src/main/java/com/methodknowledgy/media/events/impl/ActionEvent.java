package com.methodknowledgy.media.events.impl;

import com.methodknowledgy.media.events.Event;
import com.methodknowledgy.media.events.EventType;

public class ActionEvent<SourceType> implements Event<SourceType> {

	private SourceType source;
	private EventType eventType;
	private String message;

	public ActionEvent(SourceType source, EventType eventType) {
		this(source, eventType, null);
	}

	public ActionEvent(SourceType source, EventType eventType, String message) {
		this.source = source;
		this.eventType = eventType;
		this.message = message == null ? "" : message;
	}

	public SourceType getSource() {
		return source;
	}

	public EventType getEventType() {
		return eventType;
	}

	public String getMessage() {
		return message;
	}

}
