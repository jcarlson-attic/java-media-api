package com.methodknowledgy.media;

import com.methodknowledgy.media.playable.impl.PlayableImpl;
import com.methodknowledgy.media.player.Player;
import com.methodknowledgy.media.player.impl.PlayerImpl;

public class TestPlayer {

    public static void main(String[] args) {
        // Create a basic player
        Player player = new PlayerImpl();
        
        // Create a basic playable
        PlayableImpl playable = new PlayableImpl();
        
        // Have the player load and play the playable
        player.load(playable);
        
    }
    
}
