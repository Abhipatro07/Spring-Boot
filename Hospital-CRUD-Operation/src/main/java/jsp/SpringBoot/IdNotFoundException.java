package jsp.SpringBoot;

public class IdNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "ID Not Available";
	}

}
