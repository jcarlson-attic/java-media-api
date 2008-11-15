package com.methodknowledgy.media.events;

public interface Filter {

	/**
	 * The Filter determines whether a given scenario should be dispatched to a
	 * particular Action. The sole job of the Filter is to filter down incoming
	 * Events and allow only matchign Events to pass through to the Action
	 * associated with this Subscription.
	 * 
	 * @param <T>
	 * @param source
	 * @param event
	 * @param action
	 * @return True if the Event should propagate through. False if the Event
	 *         should be ignored. Null if the Filter cannot decide and chooses
	 *         to abstain (in which case the Subscription should have a default
	 *         decision for abstaining Filters.
	 */
	<T> Boolean isMatch(T source, Event event, Action action);

}
