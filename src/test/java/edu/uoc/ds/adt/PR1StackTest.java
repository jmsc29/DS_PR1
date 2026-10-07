package edu.uoc.ds.adt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PR1StackTest {

    private PR1Stack pr1s;

    private static final int[] EXPECTED_VALUES = {
        240, 210, 182, 156, 132, 110, 90, 72, 56, 42, 30, 20, 12, 6, 2
    };

    private void fillStack() {
        for (int x = 0; x < PR1Stack.CAPACITY; x++) {
            pr1s.push(PR1Function.calculate(x));
        }
    }

    @Before
    public void setUp() {
        this.pr1s = new PR1Stack();
        assertNotNull(this.pr1s.getStack());
        fillStack();
    }

    @After
    public void release() {
        this.pr1s = null;
    }

    @Test
    public void stackTest() {
        assertEquals(EXPECTED_VALUES.length, this.pr1s.getStack().size());

        for (int expected : EXPECTED_VALUES) {
            assertEquals(Integer.valueOf(expected), pr1s.pop());
        }

        assertEquals(0, this.pr1s.getStack().size());
        assertTrue(this.pr1s.getStack().isEmpty());
    }

    @Test
    public void newStackTest() {
        pr1s.newStack();
        assertEquals(0, pr1s.getStack().size());
        assertTrue(pr1s.getStack().isEmpty());

        pr1s.push(PR1Function.calculate(14));
        assertEquals(Integer.valueOf(240), pr1s.pop());
        assertTrue(pr1s.getStack().isEmpty());
    }
}
