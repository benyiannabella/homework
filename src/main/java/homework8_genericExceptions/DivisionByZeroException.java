package homework8_genericExceptions;

public class DivisionByZeroException extends Exception {

    public DivisionByZeroException(String errorMessage){
        super(errorMessage);
    }

}
