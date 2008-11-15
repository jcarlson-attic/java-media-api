package com.methodknowledgy.media.events;

public interface Filter {

	<T> Boolean isMatch(T source, Event event, Action action);

}
