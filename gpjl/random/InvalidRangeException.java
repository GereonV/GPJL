package gpjl.random;

/**
 * The {@code InvalidRangeException} represents that invalid Range-Values have been set.
 * 
 * @author  Gereon
 * @see     Exception
 * @since   0.3
 * @version 1.0
 */
public class InvalidRangeException extends Exception {

    /**
     * Super Constructor.
     * {@link Exception#Exception()}
     */
    public InvalidRangeException() {
        super();
    }

    /**
     * Super Constructor.
     * {@link Exception#Exception(String)}
     * 
     * @param message the Exception-Message
     */
    public InvalidRangeException(String message) {
        super(message);
    }

    /**
     * Super Constructor.
     * {@link Exception#Exception(Throwable)}
     * 
     * @param cause the Exception-Cause
     */
    public InvalidRangeException(Throwable cause) {
        super(cause);
    }

    /**
     * Super Constructor.
     * {@link Exception#Exception(String, Throwable)}
     * 
     * @param message the Exception-Message
     * @param cause the Exception-Cause
     */
    public InvalidRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Super Constructor.
     * 
     * @param message the Exception-Message
     * @param cause the Exception-Cause
     * @param enableSuppression whether to enable Supression
     * @param writableStackTrace whether the Stack-Trace is writable
     */
    public InvalidRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
