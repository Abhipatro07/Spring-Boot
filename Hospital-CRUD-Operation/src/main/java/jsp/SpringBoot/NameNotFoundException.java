package jsp.SpringBoot;

public class NameNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Name Not Found";
	}

}
