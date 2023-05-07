package myGoal.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import myGoal.Response.ResponseClass;

@ControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(IdAlreadyExistsException.class)
	public ResponseEntity<ResponseClass> handleIdAlreadyExistsException(IdAlreadyExistsException idAlreadyExistsException){
		ResponseClass responseClass = new ResponseClass(HttpStatus.BAD_REQUEST,"Id Already Exists");
		return new ResponseEntity<ResponseClass> (responseClass,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseClass> handleIdNotFoundException(IdNotFoundException ex) {
        ResponseClass responseClass = new ResponseClass(HttpStatus.NOT_FOUND,"Id Not Found");
        return new ResponseEntity<>(responseClass, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NumberNotFoundException.class)
    public ResponseEntity<ResponseClass> handleNumberNotFoundException(NumberNotFoundException ex) {
        ResponseClass responseClass = new ResponseClass(HttpStatus.NOT_FOUND,"Number Not Found");
        return new ResponseEntity<>(responseClass, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseClass> handlehttpmessagenotreadableexception(HttpMessageNotReadableException ex) {
        ResponseClass responseClass = new ResponseClass(HttpStatus.BAD_REQUEST,"Enter the Number");
        return new ResponseEntity<>(responseClass, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(DBisEmptyException.class)
    public ResponseEntity<ResponseClass> handleDBisEmptyException(DBisEmptyException ex) {
        ResponseClass responseClass = new ResponseClass(HttpStatus.BAD_REQUEST,"There is Nothing to retrieve");
        return new ResponseEntity<>(responseClass, HttpStatus.BAD_REQUEST);
    }
}
