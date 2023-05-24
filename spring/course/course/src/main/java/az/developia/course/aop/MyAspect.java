package az.developia.course.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.course.exception.MyBadRequestException;

@RestControllerAdvice
public class MyAspect {
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handleMyBadRequestException(MyBadRequestException exc) {
		return exc.getMessage();
	}

}
