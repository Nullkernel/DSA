import java.util.concurrent.ArrayBlockingQueue;

public class BoundedQueue {
	public static void main(String[] args) {
		ArrayBlockingQueue <Integer> boundedQueue = new ArrayBlockingQueue<>(2);
		System.out.println("The elements are: ");
		boundedQueue.add(10);
		boundedQueue.add(20);
		boolean inserted = boundedQueue.offer(30);
		if (!inserted) {
			System.out.println("Insertion failed: queue capacity reached.");
		}
		System.out.print(boundedQueue);
	}
}
