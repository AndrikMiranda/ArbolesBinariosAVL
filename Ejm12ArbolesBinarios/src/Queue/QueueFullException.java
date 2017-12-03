package Queue;

public class QueueFullException extends Exception {
	public QueueFullException() {
	}

	public QueueFullException(String causa) {
		super(causa);
	}

	public QueueFullException(Throwable causa) {
		super(causa);
	}
}
