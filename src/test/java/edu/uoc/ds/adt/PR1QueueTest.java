package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.traversal.Iterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PR1QueueTest {

    private PR1Queue pr1q;

    private static final int[] EXPECTED_VALUES = {
        2, 6, 12, 20, 30, 42, 56, 72, 90, 110, 132, 156, 182, 210, 240
    };

    private void fillQueue() {
        for (int x = 0; x < PR1Queue.CAPACITY; x++) {
            pr1q.add(PR1Function.calculate(x));
        }
    }

    @Before
    public void setUp() {
        this.pr1q = new PR1Queue();
        assertNotNull(this.pr1q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr1q = null;
    }

    @Test
    public void queueTest() {
        assertEquals(EXPECTED_VALUES.length, this.pr1q.getQueue().size());

        for (int expected : EXPECTED_VALUES) {
            assertEquals(Integer.valueOf(expected), pr1q.poll());
        }

        assertEquals(0, this.pr1q.getQueue().size());
        assertTrue(this.pr1q.getQueue().isEmpty());
    }

    @Test
    public void queueTest2() {
        Queue<Integer> queue = pr1q.getQueue();
        Iterator<Integer> it = queue.values();

        for (int expected : EXPECTED_VALUES) {
            assertTrue(it.hasNext());
            assertEquals(Integer.valueOf(expected), it.next());
        }

        assertFalse(it.hasNext());
        assertEquals(EXPECTED_VALUES.length, queue.size());
    }

    @Test
    public void newQueueTest() {
        pr1q.newQueue();
        assertEquals(0, pr1q.getQueue().size());
        assertTrue(pr1q.getQueue().isEmpty());

        pr1q.add(PR1Function.calculate(14));
        assertEquals(Integer.valueOf(240), pr1q.poll());
        assertTrue(pr1q.getQueue().isEmpty());
    }
}
