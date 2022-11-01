package lection10.lesson10;

public class CoinTechnicalException extends CoinException{

    public CoinTechnicalException() {
    }

    public CoinTechnicalException(String message) {
        super(message);
    }

    public CoinTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoinTechnicalException(Throwable cause) {
        super(cause);
    }
}
