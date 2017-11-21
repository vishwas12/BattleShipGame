
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String exceptionMsg;

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public CustomException() {
		super();
	}
	
	public CustomException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}
	
}
