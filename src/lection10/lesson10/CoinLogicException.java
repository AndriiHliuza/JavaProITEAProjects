package lection10.lesson10;

public class CoinLogicException extends CoinException{

    public CoinLogicException() {
    }

    public CoinLogicException(String message) {
        super(message);
    }

    public CoinLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoinLogicException(Throwable cause) {
        super(cause);
    }
}
