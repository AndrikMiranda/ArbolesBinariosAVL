package Queue;

public interface iQueue<T> {
	public void enQueue(T value) throws QueueFullException;

	public T deQueue() throws QueueEmptyException;

	public boolean isEmpty();

	public boolean isFull();

	public T front() throws QueueEmptyException;

	public T search(T value) throws QueueEmptyException;
	
	public void clear() throws QueueEmptyException;
	
	public boolean frontOf(T value,int priority) throws QueueFullException;
	
	public int size();
}