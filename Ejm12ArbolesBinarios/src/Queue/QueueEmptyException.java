package Queue;

public class QueueEmptyException extends Exception {
	public QueueEmptyException() {}

	public QueueEmptyException(String causa){
		super(causa);
	}

	public QueueEmptyException(Throwable causa){
		super(causa);
	}
}
