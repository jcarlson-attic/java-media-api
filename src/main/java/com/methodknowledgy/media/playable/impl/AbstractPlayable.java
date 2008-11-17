package com.methodknowledgy.media.playable.impl;

import java.util.List;
import java.util.Map;

import com.methodknowledgy.media.events.EventDispatcher;
import com.methodknowledgy.media.playable.Playable;
import com.methodknowledgy.media.playable.Segment;
import com.methodknowledgy.media.rendering.Renderer;

public class AbstractPlayable implements Playable {

	private Map<String, String> attributes;
	private Renderer renderer;
	private Long runTime;
	private List<Segment> segments;
	private State state;
	private Boolean active;
	private Boolean scrubbable;
	private Boolean skippable;

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		EventDispatcher.dispatch(this, "attributes", this.attributes, this.attributes = attributes);
	}

	public Renderer getRenderer() {
		return renderer;
	}

	public void setRenderer(Renderer renderer) {
		EventDispatcher.dispatch(this, "renderer", this.renderer, this.renderer = renderer);
	}

	public Long getRunTime() {
		return runTime;
	}

	public void setRunTime(Long runTime) {
		EventDispatcher.dispatch(this, "runTime", this.runTime, this.runTime = runTime);
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		EventDispatcher.dispatch(this, "segments", this.segments, this.segments = segments);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		EventDispatcher.dispatch(this, "state", this.state, this.state = state);
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		EventDispatcher.dispatch(this, "active", this.active,
				this.active = active);
	}

	public Boolean isScrubbable() {
		return scrubbable;
	}

	public void setScrubbable(Boolean scrubbable) {
		EventDispatcher.dispatch(this, "scrubbable", this.scrubbable, this.scrubbable = scrubbable);
	}

	public Boolean isSkippable() {
		return skippable;
	}

	public void setSkippable(Boolean skippable) {
		EventDispatcher.dispatch(this, "skippable", this.skippable, this.skippable = skippable);
	}

	public void render() {
		if (getRenderer() != null) {
			getRenderer().render();
		}
	}

}
