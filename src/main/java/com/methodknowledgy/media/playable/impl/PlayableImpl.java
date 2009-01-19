package com.methodknowledgy.media.playable.impl;

import java.util.Map;

import com.methodknowledgy.media.playable.Playable;

public class PlayableImpl implements Playable {

    private Map<String, String> attributes;
    private Long runTime;
    private State state;
    private Boolean active;
    private Boolean scrubbable;
    private Boolean skippable;
    
    public void initialize() {
        setState(State.LOADING);
        // whatever other prep-work needs done
        setState(State.READY);
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean isScrubbable() {
        return scrubbable;
    }

    public void setScrubbable(Boolean scrubbable) {
        this.scrubbable = scrubbable;
    }

    public Boolean isSkippable() {
        return skippable;
    }

    public void setSkippable(Boolean skippable) {
        this.skippable = skippable;
    }

}
