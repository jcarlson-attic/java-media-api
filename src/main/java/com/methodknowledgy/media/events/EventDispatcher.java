package com.methodknowledgy.media.events;

import java.util.ArrayList;
import java.util.List;

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

	public static <T> void dispatch(T source, Event event) {
		for (Subscription subscription : instance) {
			subscription.executeIfValid(source, event);
		}
	}

}
