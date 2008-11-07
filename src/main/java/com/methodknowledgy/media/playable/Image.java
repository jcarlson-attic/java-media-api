package com.methodknowledgy.media.playable;

import java.net.URL;

public interface Image extends Playable {

	URL getURL();

	Dimensions getDimensions();

	public class Dimensions {
		public int width;
		public int height;

		public Dimensions(int w, int h) {
			this.width = w;
			this.height = h;
		}
	}

}
