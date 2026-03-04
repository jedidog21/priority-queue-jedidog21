import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    @Test
    void testAdd() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(4);
        pq.add(5);
        assertEquals(4, pq.peek());
    }

    @Test
    void testContains() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(4);
        pq.add(5);
        assertTrue(pq.contains(4));
    }

    @Test
    void testPeek() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(4);
        pq.add(5);
        assertEquals(4, pq.peek());
    }

    @Test
    void testPoll() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(4);
        pq.add(5);
        pq.poll();
        assertEquals(5, pq.poll());
    }

    @Test
    void testRemove() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(4);
        pq.add(5);
        assertTrue(pq.remove(30));
    }

    @Test
    void testSize() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(4);
        pq.add(5);
        assertEquals(4, pq.size());
    }

    @Test
    void testToString1() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(4);
        pq.add(5);
        assertEquals("4 5 10 30", pq.toString());
    }

    @Test
    void clear() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(4);
        pq.add(5);
        pq.clear();
        assertNull(pq.peek());
    }
}