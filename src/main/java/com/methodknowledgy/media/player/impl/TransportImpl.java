package com.methodknowledgy.media.player.impl;

import com.methodknowledgy.events.dispatch.EventDispatcher;
import com.methodknowledgy.events.impl.ChangeEvent;
import com.methodknowledgy.events.impl.SingleValueEvent;
import com.methodknowledgy.media.player.Transport;

public class TransportImpl implements Transport {

    private Double rate;

    public void next() {
        SingleValueEvent<Transport, Integer> event = new SingleValueEvent<Transport, Integer>(
                this, "TRANSPORT_NEXT", 1,
                "Transport is requesting advance to the next Playable.");
        EventDispatcher.getInstance().dispatch(event);
    }

    public void previous() {
        SingleValueEvent<Transport, Integer> event = new SingleValueEvent<Transport, Integer>(
                this, "TRANSPORT_PREVIOUS", -1,
                "Transport is requesting advance to the previous Playable.");
        EventDispatcher.getInstance().dispatch(event);
    }

    public void transport(Double rate) {
        ChangeEvent<Transport, Double> event = new ChangeEvent<Transport, Double>(
                this, "TRANSPORT_RATE", this.rate, this.rate = rate,
                "Transport is requesting a change in playback speed.");
        EventDispatcher.getInstance().dispatch(event);
    }

}
