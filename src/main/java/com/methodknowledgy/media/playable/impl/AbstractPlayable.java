package com.methodknowledgy.media.playable.impl;

import java.util.List;
import java.util.Map;

import com.methodknowledgy.events.dispatch.EventDispatcher;
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
        EventDispatcher.getInstance().dispatch(this, "attributes",
                this.attributes, this.attributes = attributes);
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        EventDispatcher.getInstance().dispatch(this, "renderer", this.renderer,
                this.renderer = renderer);
    }

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        EventDispatcher.getInstance().dispatch(this, "runTime", this.runTime,
                this.runTime = runTime);
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        EventDispatcher.getInstance().dispatch(this, "segments", this.segments,
                this.segments = segments);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        EventDispatcher.getInstance().dispatch(this, "state", this.state,
                this.state = state);
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        EventDispatcher.getInstance().dispatch(this, "active", this.active,
                this.active = active);
    }

    public Boolean isScrubbable() {
        return scrubbable;
    }

    public void setScrubbable(Boolean scrubbable) {
        EventDispatcher.getInstance().dispatch(this, "scrubbable",
                this.scrubbable, this.scrubbable = scrubbable);
    }

    public Boolean isSkippable() {
        return skippable;
    }

    public void setSkippable(Boolean skippable) {
        EventDispatcher.getInstance().dispatch(this, "skippable",
                this.skippable, this.skippable = skippable);
    }

    public void render() {
        if (getRenderer() != null) {
            getRenderer().render();
        }
    }

}
