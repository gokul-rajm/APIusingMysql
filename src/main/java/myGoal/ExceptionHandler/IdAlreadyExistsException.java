package myGoal.ExceptionHandler;

public class IdAlreadyExistsException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;
	public IdAlreadyExistsException(String message) {
        super(message);
    }
    public IdAlreadyExistsException() {
    }
}