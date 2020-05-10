package homework8_genericExceptions;

public class UnrecognisedCharacterException  extends RuntimeException{
    public UnrecognisedCharacterException (String message){
        super(message);
    }
}
