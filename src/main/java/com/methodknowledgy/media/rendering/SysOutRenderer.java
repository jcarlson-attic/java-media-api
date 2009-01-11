package com.methodknowledgy.media.rendering;

import com.methodknowledgy.events.Event;
import com.methodknowledgy.events.dispatch.Action;
import com.methodknowledgy.events.dispatch.EventDispatcher;
import com.methodknowledgy.events.dispatch.Filter;
import com.methodknowledgy.events.dispatch.impl.Subscription;
import com.methodknowledgy.events.impl.ChangeEvent;
import com.methodknowledgy.media.playable.Playable;

public class SysOutRenderer implements Renderer {

    public void render() {
        EventDispatcher
                .getInstance()
                .dispatch(
                        new ChangeEvent<Renderer, Playable.State>(this,
                                "playable_playState", Playable.State.READY,
                                Playable.State.RUNNING,
                                "Renderer indicated current Playable has started running"));

        for (long i = 0; i < 5; i++) {
            EventDispatcher.getInstance().dispatch(
                    new ChangeEvent<Renderer, Long>(this, "playable_position",
                            i == 0 ? null : i - 1, i));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {

            }
        }

        EventDispatcher.getInstance().dispatch(
                new ChangeEvent<Renderer, Playable.State>(this,
                        "playable_playState", Playable.State.RUNNING,
                        Playable.State.FINISHED,
                        "Renderer indicated current Playable has finished"));

    }

    public static void main(String[] args) {
        final Subscription s = new Subscription();
        final Renderer r = new SysOutRenderer();
        s.setAction(new ElapsedTimeLogger());
        EventDispatcher.getInstance().register(s);
        s.setFilter(new Filter() {

            public <E extends Event<?, ?>> Boolean isMatch(E event,
                    Action action) {
                return event.getSource().equals(r) && event.getPropertyName().equals("playable_position");
            }
            
        });
        r.render();

    }

    private static class ElapsedTimeLogger implements Action {

        public <E extends Event<?, ?>> void execute(E event) {
            System.out.println("Elapsed time 0:0" + event.getNewValue());
        }

    }

}
