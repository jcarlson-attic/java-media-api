package com.methodknowledgy.media.player;

import com.methodknowledgy.events.dispatch.EventDispatcher;
import com.methodknowledgy.events.util.AutoEventLogger;
import com.methodknowledgy.media.playable.impl.PlayableImpl;
import com.methodknowledgy.media.player.impl.BasicPlayer;

public class TestPlayer {

    public static void main(String[] args) {
        // Establish a global logger for all dispatched events
        AutoEventLogger logger = new AutoEventLogger();
        EventDispatcher.getInstance().register(logger);

        // Create a basic player
        Player player = new BasicPlayer();
        
        // Create a basic playable
        PlayableImpl playable = new PlayableImpl();
        
        // Have the player load and play the playable
        player.load(playable);
        
    }
    
}
