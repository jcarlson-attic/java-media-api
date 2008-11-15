package com.methodknowledgy.media.events.impl;

import com.methodknowledgy.media.events.Action;
import com.methodknowledgy.media.events.Event;
import com.methodknowledgy.media.events.Filter;
import com.methodknowledgy.media.events.Subscription;

public class SubscriptionImpl implements Subscription {

	private Action action;
	private Filter filter;
	private boolean validOnFilterAbstain;

	public <E extends Event<?>> boolean isValidForEvent(E event) {
		if (filter == null) {
			return true;
		}
		Boolean match = filter.isMatch(event, action);
		if (match == null) {
			return validOnFilterAbstain;
		}
		return match;
	}

	public <E extends Event<?>> void executeIfValid(E event) {
		if (isValidForEvent(event) && action != null) {
			action.execute(event);
		}
	}

	public boolean isValidOnFilterAbstain() {
		return validOnFilterAbstain;
	}

	public void setValidOnFilterAbstain(boolean executeOnFilterAbstain) {
		this.validOnFilterAbstain = executeOnFilterAbstain;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

}
