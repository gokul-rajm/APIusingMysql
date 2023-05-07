package myGoal.ExceptionHandler;

public class DBisEmptyException extends RuntimeException{

	 private static final long serialVersionUID = 1L;
		public DBisEmptyException(String message) {
	        super(message);
	    }
	    public DBisEmptyException() {
	    }
}
