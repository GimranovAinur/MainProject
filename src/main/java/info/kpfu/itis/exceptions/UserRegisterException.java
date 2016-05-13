package info.kpfu.itis.exceptions;

/**
 * Created by asus2 on 10.05.16.
 */
public class UserRegisterException extends Exception{

    public UserRegisterException() {
        super();
    }

    public UserRegisterException(String message) {
        super(message);
    }

    public UserRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRegisterException(Throwable cause) {
        super(cause);
    }

}
