package az.developia.course.exception;

public class MyBadRequestException extends RuntimeException {
	
	public MyBadRequestException(String message) {
		super(message);
	}

}
