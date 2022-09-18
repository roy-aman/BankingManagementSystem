package roy.aman.bankingmanagementsystem.Exceptions;


public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);

    }

    public ApiException() {
        super();

    }
}
