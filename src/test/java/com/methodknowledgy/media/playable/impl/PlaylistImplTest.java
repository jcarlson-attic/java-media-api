package com.methodknowledgy.media.playable.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.methodknowledgy.media.playable.Playable;
import com.methodknowledgy.media.playable.Segment;
import com.methodknowledgy.media.rendering.Renderer;

public class PlaylistImplTest {

    private static Playable a, b, c, d, e, f;

    private PlaylistImpl list;
    private Vector<Playable> vector;

    @BeforeClass
    public static void oneTimeSetup() {
        a = new TestPlayable();
        b = new TestPlayable();
        c = new TestPlayable();
        d = new TestPlayable();
        e = new TestPlayable();
        f = new TestPlayable();
    }

    @Before
    public void setup() {
        vector = new Vector<Playable>(6);
        list = new PlaylistImpl();
    }

    private void populate() {
        vector.add(0, a);
        vector.add(1, b);
        vector.add(2, c);
        vector.add(3, d);
        vector.add(4, e);
        vector.add(5, f);

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
    }
    
    private Collection<Playable> collection() {
        Collection<Playable> collection = new ArrayList<Playable>();
        collection.add(d);
        collection.add(e);
        collection.add(f);
        return collection;
    }

    @Test
    public void vector_equivalence() {
        populate();
        Assert.assertArrayEquals("toArray() to not equal", vector.toArray(),
                list.toArray());
        Assert.assertTrue("Vector says the PlaylistImpl is not equal", vector
                .equals(list));
    }

    @Test
    public void hasCurrent() {
        Assert.assertFalse("Playlist says it has a current item", list
                .hasCurrent());

        list.add(a);

        Assert.assertTrue("Playlist says it does not have a current item", list
                .hasCurrent());

        list.clear();

        Assert.assertFalse("Playlist says it has a current item", list
                .hasCurrent());
    }

    @Test
    public void current() {
        Assert.assertNull("Current item should be {null}", list.current());

        list.add(a);

        Assert.assertEquals("Current item is not correct. Should be {a}", a,
                list.current());

        list.add(b);

        Assert.assertEquals("Current item is not correct. Should be {a}", a,
                list.current());

        list.setIndex(1);

        Assert.assertEquals("Current item is not correct. Should be {b}", b,
                list.current());

        list.clear();

        Assert.assertNull("Current item should be {null}", list.current());
    }

    @Test
    public void currentIndex() {
        Assert
                .assertNull("Current index should be {null}", list
                        .currentIndex());

        list.add(a);

        Assert.assertEquals("Current index is not correct. Should be {0}",
                new Integer(0), list.currentIndex());

        list.add(b);

        Assert.assertEquals("Current index is not correct. Should be {0}",
                new Integer(0), list.currentIndex());

        list.setIndex(1);

        Assert.assertEquals("Current index is not correct. Should be {1}",
                new Integer(1), list.currentIndex());

        list.setIndex(0);

        Assert.assertEquals("Current index is not correct. Should be {0}",
                new Integer(0), list.currentIndex());

        list.clear();

        Assert
                .assertNull("Current index should be {null}", list
                        .currentIndex());
    }

    @Test
    public void hasNext() {
        Assert.assertFalse("Playlist should not have next", list.hasNext());

        list.add(a);

        Assert.assertFalse("Playlist should not have next", list.hasNext());

        list.add(b);

        Assert.assertTrue("Playlist should not next", list.hasNext());

        list.setIndex(1);

        Assert.assertFalse("Playlist should not have next", list.hasNext());

    }

    @Test
    public void hasPrevious() {
        Assert.assertFalse("Playlist should not have previous", list
                .hasPrevious());

        list.add(a);

        Assert.assertFalse("Playlist should not have previous", list
                .hasPrevious());

        list.add(b);
        list.setIndex(1);

        Assert.assertTrue("Playlist should have previous", list.hasPrevious());

    }

    @Test
    public void next() {
        Assert.assertNull("Playlist should not have next", list.next());

        list.add(a);

        Assert.assertNull("Playlist should not have next", list.next());

        list.add(b);

        Assert.assertEquals("Next should have equaled {b}", b, list.next());

        Assert.assertNull("Playlist should not have next", list.next());
    }

    @Test
    public void nextIndex() {
        Assert.assertNull("Playlist should not have next index", list
                .nextIndex());

        list.add(a);

        Assert.assertNull("Playlist should not have next index", list
                .nextIndex());

        list.add(b);

        Assert.assertEquals("Next should have equaled {1}", new Integer(1),
                list.nextIndex());
    }

    @Test
    public void previous() {
        Assert.assertNull("Playlist should not have previous", list.previous());

        list.add(a);

        Assert.assertNull("Playlist should not have previous", list.previous());

        list.add(b);
        list.setIndex(1);

        Assert.assertEquals("Previous should have equaled {a}", a, list
                .previous());

        Assert.assertNull("Playlist should not have previous", list.previous());
    }

    @Test
    public void previousIndex() {
        Assert.assertNull("Playlist should not have previous index", list
                .previousIndex());

        list.add(a);

        Assert.assertNull("Playlist should not have previous index", list
                .previousIndex());

        list.add(b);
        list.setIndex(1);

        Assert.assertEquals("Previous should have equaled {0}", new Integer(0),
                list.previousIndex());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void jumpTo_empty() {
        list.jumpTo(0);
    }

    @Test
    public void jumpTo_item() {
        list.add(a);
        
        Assert.assertEquals(a, list.jumpTo(0));

        list.add(b);
        
        Assert.assertEquals(b, list.jumpTo(1));
    }
    
    @Test
    public void add() {
        list.add(a);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        
        list.add(b);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
    }
    
    @Test
    public void addAll_empty() {
        list.addAll(collection());
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
    }
    
    @Test
    public void addAll_existing() {
        list.add(a);
        list.addAll(collection());
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
    }

    @Test
    public void addAll_empty_index() {
        list.addAll(0, collection());

        Assert.assertEquals("Incorrect current index", new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {d}", d, list.current());
    }

    @Test
    public void addAll_before() {
        list.add(a);
        list.add(b);
        list.setIndex(1);
        list.addAll(0, collection());
        
        Assert.assertEquals("Incorrect current index", new Integer(4), list.currentIndex());
        Assert.assertEquals("Current item was not {b}", b, list.current());
    }
    
    @Test
    public void addAll_after() {
        list.add(a);
        list.addAll(1, collection());
        
        Assert.assertEquals("Incorrect current index", new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
    }
    
    @Test
    public void addAll_current() {
        list.add(a);
        list.addAll(0, collection());
        
        Assert.assertEquals("Incorrect current index", new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {d}", d, list.current());
    }

    @Test
    public void addElement_empty() {
        list.addElement(a);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
    }
    
    @Test
    public void addElement_existing() {
        list.add(a);
        list.addElement(b);

        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
    }
    
    @Test
    public void insertElement_empty() {
        list.insertElementAt(a, 0);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
    }

    @Test
    public void insertElement_before() {
        list.add(a);
        list.add(b);
        list.setIndex(1);
        list.insertElementAt(c, 0);
        
        Assert.assertEquals(new Integer(2), list.currentIndex());
        Assert.assertEquals("Current item was not {b}", b, list.current());
    }

    @Test
    public void insertElement_current() {
        list.add(a);
        list.insertElementAt(b, 0);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {b}", b, list.current());
    }
    
    @Test
    public void remove_after() {
        populate();
        list.remove(1);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
    }
    
    @Test
    public void remove_before() {
        populate();
        list.setIndex(1);
        list.remove(0);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {b}", b, list.current());
    }
    
    @Test
    public void remove_current_middle() {
        populate();
        list.setIndex(1);
        list.remove(1);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
    }
    
    @Test
    public void remove_current_first() {
        populate();
        list.remove(0);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {b}", b, list.current());
    }
    
    @Test
    public void remove_all() {
        list.add(a);
        list.remove(0);
        
        Assert.assertNull(list.currentIndex());
        Assert.assertNull("Current item was not {null}", list.current());
    }
    
    @Test
    public void removeAllElements() {
        populate();
        list.removeAllElements();

        Assert.assertNull(list.currentIndex());
        Assert.assertNull("Current item was not {null}", list.current());
    }
    
    @Test
    public void removeElementAt_after() {
        populate();
        list.removeElementAt(1);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
    }
    
    @Test
    public void removeElementAt_before() {
        populate();
        list.setIndex(1);
        list.removeElementAt(0);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {b}", b, list.current());
    }
    
    @Test
    public void removeElementAt_current_middle() {
        populate();
        list.setIndex(1);
        list.removeElementAt(1);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
    }
    
    @Test
    public void removeElementAt_current_first() {
        populate();
        list.removeElementAt(0);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {b}", b, list.current());
    }
    
    @Test
    public void removeElementAt_all() {
        list.add(a);
        list.removeElementAt(0);
        
        Assert.assertNull(list.currentIndex());
        Assert.assertNull("Current item was not {null}", list.current());
    }
    
    @Test
    public void removeRange_after() {
        populate();
        list.removeRange(1, 3);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
        Assert.assertEquals("Next item was not {d}", d, list.next());
    }
    
    @Test
    public void removeRange_before() {
        populate();
        list.setIndex(2);
        list.removeRange(0, 2);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {c}", c, list.current());
        Assert.assertEquals("Next item was not {d}", d, list.next());
    }
    
    @Test
    public void removeRange_inclusive() {
        populate();
        list.setIndex(2);
        list.removeRange(1, 4);
        
        Assert.assertEquals(new Integer(0), list.currentIndex());
        Assert.assertEquals("Current item was not {a}", a, list.current());
        Assert.assertEquals("Next item was not {e}", e, list.next());
    }
    
    @Test
    public void removeRange_all() {
        populate();
        list.setIndex(1);
        list.removeRange(0, 6);
        
        Assert.assertNull(list.currentIndex());
        Assert.assertNull("Current item was not {null}", list.current());
    }
    
    private static class TestPlayable implements Playable {

        public void initialize() {
            
        }
        
        public Map<String, String> getAttributes() {
            return null;
        }

        public Renderer getRenderer() {
            return null;
        }

        public Long getRunTime() {
            return null;
        }

        public List<Segment> getSegments() {
            return null;
        }

        public State getState() {
            return null;
        }

        public Boolean isActive() {
            return null;
        }

        public Boolean isScrubbable() {
            return null;
        }

        public Boolean isSkippable() {
            return null;
        }

        public void render() {

        }

    }

}
