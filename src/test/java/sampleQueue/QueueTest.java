package sampleQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;
	private Queue<String> q2;

	@Test
	@DisplayName("is instantiated with new Queue()")
	void isInstantiatedWithNew() {
		new Queue<>();
	}

	
	@Test
	@DisplayName("is instantiated with new Queue(int)")
	void isInstantiatedWithInt() {
		new Queue<>(2);
	}
	
	@BeforeEach
	void init() {
		this.q = new Queue<String>();
		this.q2 = new Queue<String>(1);
	}

	@Test 
	@DisplayName("enqueueOutOfBoundException")
	void isEnqueWorking() {
		IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
	 	q2.enqueue(SOME_ITEM);
		q2.enqueue(SOME_ITEM);
	        });
	    assertEquals("Index Out of Bounds", exception.getMessage());
	}
	
	
	//q2 is set to length of 1, test if it is not 1 (also failling)
	@Test
	@DisplayName("enqeue failling")
	public void testEnqueue_maxlenghth() {
		q2.enqueue("abc");
		q2.enqueue("def");
		assertEquals(1, q2.size());
	}
	
	//normal enqueue
	@Test
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void normalenqueue() {
		this.q.enqueue(SOME_ITEM);
		assertEquals(q.peek(), SOME_ITEM);
	}

	@Test
	@DisplayName("test for dequeue working normally")
	void isDequeueworking() {
		this.q2.enqueue(SOME_ITEM);
		assertTrue(SOME_ITEM == this.q2.dequeue());
	}
	
	
	@Test
	@DisplayName("Deque throws exception when is empty")
	void DeqeueThrowsException() {
		this.q2.enqueue(SOME_ITEM);
		this.q2.dequeue();
	    assertThrows(NoSuchElementException.class, () -> {
	            this.q2.dequeue();});
		
	}
	
	@Test
	@DisplayName("Test for working peek")
	void PeekIsWorking() {
		this.q.enqueue("123");
		this.q.enqueue("456");
		this.q.enqueue("abc");
		this.q.enqueue("def");
		assertEquals("123", q.peek() );		
	}
	
	
	@Test
	@DisplayName("Test for peek return exception when is empty")
	void PeekGivesException() {
		this.q2.enqueue(SOME_ITEM);
		this.q2.dequeue();
		assertThrows(NoSuchElementException.class, () -> {
            this.q2.peek();});
	}
	
	@Test
	@DisplayName("Test for length is working")
	void LengthIsWorking() {
		this.q.enqueue("123");
		this.q.enqueue("456");
		this.q.enqueue("abc");
		this.q.enqueue("def");
		assertEquals(4, this.q.length() );		
	}
	
	@Test
	@DisplayName("Test for removeall is working")
	void RemoveAllIsWorking() {
		this.q.enqueue("123");
		this.q.enqueue("456");
		this.q.enqueue("abc");
		this.q.enqueue("def");
		this.q.removeAll();
		assertTrue(this.q.isEmpty());		
	}
	
	@Test
	@DisplayName("Verify Queue isEmpty returns True when queue is empty")
	void isEmptyShouldGiveTrueWhenQueueIsEmpty() {
		this.q2.enqueue(SOME_ITEM);
		this.q2.dequeue();
		assertTrue(q.isEmpty());
	}
	
	@Test
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
		this.q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}
	
	
	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}

	//Example of Wrong Test! 
//	@Test
//	@Disabled
//	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
//	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
//		this.q.enqueue(SOME_ITEM);
//		assertFalse(q.isEmpty());
//	}

	
}