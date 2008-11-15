package com.methodknowledgy.media.events.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.methodknowledgy.media.events.Action;
import com.methodknowledgy.media.events.Event;
import com.methodknowledgy.media.events.Filter;

public class SubscriptionImplTest {

	@Before
	public void createMockObjects() {
	}
	
	@Test
	public void subscription_with_positive_filter() {
		SubscriptionImpl s = new SubscriptionImpl();
		s.setFilter(getTrueFilter());
		Assert.assertTrue(s.isValidForEvent(null, null));
	}
	
	@Test
	public void subscription_with_negative_filter() {
		SubscriptionImpl s = new SubscriptionImpl();
		s.setFilter(getFalseFilter());
		Assert.assertFalse(s.isValidForEvent(null, null));
	}
	
	@Test
	public void subscription_with_abstaining_filter() {
		SubscriptionImpl s = new SubscriptionImpl();
		s.setFilter(getNullFilter());
		
		s.setValidOnFilterAbstain(true);
		Assert.assertTrue(s.isValidForEvent(null, null));

		s.setValidOnFilterAbstain(false);
		Assert.assertFalse(s.isValidForEvent(null, null));
	}
	
	@Test
	public void subscription_with_no_filter() {
		SubscriptionImpl s = new SubscriptionImpl();
		Assert.assertTrue(s.isValidForEvent(null, null));
	}
	
	@Test
	public void execute_when_valid() {
		SubscriptionImpl s = new SubscriptionImpl();
		TestAction action = new TestAction();
		s.setAction(action);
		s.executeIfValid(null, null);
		Assert.assertTrue(action.executed);
	}
	
	@Test
	public void execute_when_not_valid() {
		SubscriptionImpl s = new SubscriptionImpl();
		TestAction action = new TestAction();
		s.setAction(action);
		s.setFilter(getFalseFilter());
		s.executeIfValid(null, null);
		Assert.assertFalse(action.executed);
	}
	
	
	
	
	
	private Filter getTrueFilter() {
		return new Filter() {
			public <T> Boolean isMatch(T source, Event event, Action action) {
				return Boolean.TRUE;
			}
		};
	}
	
	private Filter getFalseFilter() {
		return new Filter() {
			public <T> Boolean isMatch(T source, Event event, Action action) {
				return Boolean.FALSE;
			}
		};
	}
	
	private Filter getNullFilter() {
		return new Filter() {
			public <T> Boolean isMatch(T source, Event event, Action action) {
				return null;
			}
		};
	}
	
	private class TestAction implements Action {
		public boolean executed = false;
		public <T> void execute(T source, Event event) {
			executed = true;
		}
	}
	
}
