package lection10.lesson10;

public class CoinException extends Exception{
    public CoinException() {
    }

    public CoinException(String message) {
        super(message);
    }

    public CoinException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoinException(Throwable cause) {
        super(cause);
    }

    public CoinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
