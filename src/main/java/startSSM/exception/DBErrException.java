package startSSM.exception;

@SuppressWarnings("serial")
public class DBErrException extends Exception{
	public DBErrException(){
		super();
	}
	public DBErrException(String message){
		super(message);
	}
}