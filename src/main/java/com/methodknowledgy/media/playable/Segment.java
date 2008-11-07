package com.methodknowledgy.media.playable;

import java.util.Map;

/**
 * <p>
 * A Segment represents a portion of a Playable much the same way Chapters
 * divide a book. Segments are not necessary to use and are typically entirely
 * metadata-based.
 * </p>
 * 
 * <p>
 * All Playables have segments. If segments are not defined explicitly, a single
 * segment is created automatically to encompass the entire duration of the
 * Playable.
 * </p>
 * 
 * @author jcarlson
 * 
 */
public interface Segment {

	Segment getPrevious();
	
	Segment getNext();
	
	Integer getIndex();
	
	Long getRunTime();
	
	Map<String, String> getAttributes();
	
	// TODO: Define a Segment

}
