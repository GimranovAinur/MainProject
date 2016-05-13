package info.kpfu.itis.exceptions;

/**
 * Created by asus2 on 10.05.16.
 */
public class PostsException extends Exception {
    public PostsException() {
        super();
    }

    public PostsException(String message) {
        super(message);
    }

    public PostsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostsException(Throwable cause) {
        super(cause);
    }

    protected PostsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
