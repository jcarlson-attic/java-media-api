package com.methodknowledgy.media.events.impl;

import com.methodknowledgy.media.events.Event;

public class PropertyChangeEvent<SourceType, PropertyType> implements Event<SourceType> {

	private SourceType source;
	private String propertyName;
	private PropertyType oldValue;
	private PropertyType newValue;
	private String message;

	public PropertyChangeEvent(SourceType source, String propertyName,
			PropertyType oldValue, PropertyType newValue) {
		this(source, propertyName, oldValue, newValue, "");
	}

	public PropertyChangeEvent(SourceType source, String propertyName,
			PropertyType oldValue, PropertyType newValue, String message) {
		this.source = source;
		this.propertyName = propertyName;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.message = message == null ? "" : message;
	}

	public SourceType getSource() {
		return source;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public PropertyType getOldValue() {
		return oldValue;
	}

	public PropertyType getNewValue() {
		return newValue;
	}

	public String getMessage() {
		return message;
	}

}
