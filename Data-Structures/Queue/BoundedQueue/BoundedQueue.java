import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;

public class BoundedQueue {
	private static void printCheck(String label, Object expected, Object got) {
		System.out.println(label + " -> Expected: " + expected + " | Got: " + got);
	}
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> boundedQueue = new ArrayBlockingQueue<>(2);
		printCheck("Initial Queue", "[]", boundedQueue.toString());
		boundedQueue.add(10);
		boundedQueue.add(20);
		printCheck("After adding 10, 20", "[10, 20]", boundedQueue.toString());
		boolean inserted = boundedQueue.offer(30);
		printCheck("offer(30) when Full", false, inserted);
		printCheck("peek() on NON-Empty Queue", 10, boundedQueue.peek());
		printCheck("poll() on NON-Empty Queue", 10, boundedQueue.poll());
		printCheck("Queue after poll()", "[20]", boundedQueue.toString());
		printCheck("remove() on NON-Empty Queue", 20, boundedQueue.remove());
		printCheck("Queue after remove()", "[]", boundedQueue.toString());
		printCheck("peek() on Empty Queue", null, boundedQueue.peek());
		printCheck("poll() on Empty Queue", null, boundedQueue.poll());
		try {
			boundedQueue.remove();
			printCheck("remove() on Empty Queue", "NoSuchElementException", "No exception");
		} catch (NoSuchElementException ex) {
			printCheck("remove() on Empty Queue", "NoSuchElementException", ex.getClass().getSimpleName());
		}
	}
}
