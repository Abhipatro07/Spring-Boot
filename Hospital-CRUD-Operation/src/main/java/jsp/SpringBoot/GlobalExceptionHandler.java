package jsp.SpringBoot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException e){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setStatusCode(HttpStatus.NOT_FOUND.value());
		str.setMeassage("Not ound");
		str.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNameNotFoundException(NameNotFoundException e){
		ResponseStructure<String> str = new ResponseStructure<String>();
		str.setStatusCode(HttpStatus.NOT_FOUND.value());
		str.setMeassage("Not ound");
		str.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND);
	}

}
