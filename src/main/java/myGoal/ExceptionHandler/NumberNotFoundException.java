package myGoal.ExceptionHandler;

public class NumberNotFoundException extends RuntimeException{

	 private static final long serialVersionUID = 1L;
		
	 public NumberNotFoundException(String message) {
	        super(message);
	    }
	    public NumberNotFoundException() {
	    }
}
