package lection16.lesson16;

public class ResourceException extends Exception{
    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }
}
