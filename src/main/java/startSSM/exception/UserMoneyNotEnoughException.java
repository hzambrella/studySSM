package startSSM.exception;

@SuppressWarnings("serial")
public class UserMoneyNotEnoughException extends Exception{
	public UserMoneyNotEnoughException(){
		super();
	}
	public UserMoneyNotEnoughException(String message){
		super(message);
	}
}