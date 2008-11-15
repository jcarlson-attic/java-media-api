package com.methodknowledgy.media.events;

import java.util.ArrayList;
import java.util.List;

import com.methodknowledgy.media.events.impl.PropertyChangeEvent;

public class EventDispatcher {

	private static List<Subscription> instance = new ArrayList<Subscription>();

	private EventDispatcher() {
	}

	public static void register(Subscription subscription) {
		instance.add(subscription);
	}

	public static void unregister(Subscription subscription) {
		instance.remove(subscription);
	}

	public static <E extends Event<?>> void dispatch(E event) {
		for (Subscription subscription : instance) {
			subscription.executeIfValid(event);
		}
	}

	public static <S, T> void dispatch(S source, String propertyName, T oldValue, T newValue) {
		dispatch(source, propertyName, oldValue, newValue, "");
	}

	public static <S, T> void dispatch(S source, String propertyName, T oldValue, T newValue, String message) {
		PropertyChangeEvent<S, T> event = new PropertyChangeEvent<S, T>(
				source, propertyName, oldValue, newValue, message);
		dispatch(event);
	}
}
