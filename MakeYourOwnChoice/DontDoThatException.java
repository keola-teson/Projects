
/**
 * Custom Exception for my game
 */
public class DontDoThatException extends RuntimeException
{
	//not sure what this is for tbh
	private static final long serialVersionUID = -4062993266381950298L;
	
	/**
	 * default constructor
	 */
	public DontDoThatException()
	{
		super("Don' do that");
	}
	
	/**
	 * constructor for passing a message
	 * @param message
	 */
	public DontDoThatException(String message)
	{
		super(message);
	}
	
	/**
	 * constructor for passing a message and a throwable
	 * @param message
	 * @param cause
	 */
	public DontDoThatException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
