package com.methodknowledgy.media.player.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.methodknowledgy.media.playable.Playable;
import com.methodknowledgy.media.playable.Segment;
import com.methodknowledgy.media.playable.impl.AbstractPlayable;
import com.methodknowledgy.media.player.Playlist;
import com.methodknowledgy.media.rendering.Renderer;

public class PlaylistImpl implements Playlist {

	private static final long serialVersionUID = 1L;
	private ArrayList<Playable> playlist = new ArrayList<Playable>();
	private ListIterator<Playable> iterator = playlist.listIterator();
	private Playable current;
	private Integer currentIndex;

	public Playable getCurrent() {
		return current;
	}

	public Integer getCurrentIndex() {
		return playlist.indexOf(current);
	}

	public Map<String, String> getAttributes() {
		if (current != null) {
			return current.getAttributes();
		}
		return null;
	}

	public Renderer getRenderer() {
		if (current != null) {
			return current.getRenderer();
		}
		return null;
	}

	public Long getRunTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Segment> getSegments() {
		if (current != null) {
			return current.getSegments();
		}
		return null;
	}

	public State getState() {
		if (current != null) {
			return current.getState();
		}
		return null;
	}

	public Boolean isActive() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isScrubbable() {
		if (current != null) {
			return current.isScrubbable();
		}
		return null;
	}

	public Boolean isSkippable() {
		if (current != null) {
			return current.isSkippable();
		}
		return null;
	}

	public void render() {
		if (current != null) {
			current.render();
		}
	}

	/* ListIterator wrapper methods */

	public void add(Playable playable) {
		iterator.add(playable);
		if (currentIndex == null) {
			currentIndex = iterator.previousIndex();
		}
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public boolean hasPrevious() {
		return iterator.hasPrevious();
	}

	public Playable next() {
		current = iterator.next();
		return current;
	}

	public int nextIndex() {
		return iterator.nextIndex();
	}

	public Playable previous() {
		current = iterator.previous();
		return current;
	}

	public int previousIndex() {
		return iterator.previousIndex();
	}

	public void remove() {
		iterator.remove();
	}

	public void set(Playable playable) {
		iterator.set(playable);
	}

	public static void main(String[] args) {
		Playlist p = new PlaylistImpl();
		System.out.println("Initial current index: " + p.getCurrentIndex());
		System.out.println("Initial current: " + p.getCurrent());
		System.out.println("Initial hasNext: " + p.hasNext());

		System.out.println();
		
		p.add(new AbstractPlayable());

		System.out.println("Current index after add: "
				+ p.getCurrentIndex());
		System.out.println("Current: " + p.getCurrent());
		System.out.println("Current hasNext: " + p.hasNext());

		System.out.println();

		p.add(new AbstractPlayable());

		System.out.println("Final index after add: "
				+ p.getCurrentIndex());
		System.out.println("Final: " + p.getCurrent());
		System.out.println("Final hasNext: " + p.hasNext());

	}

}
