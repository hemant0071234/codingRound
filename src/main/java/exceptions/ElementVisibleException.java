package exceptions;

public class ElementVisibleException extends RuntimeException {
    public ElementVisibleException(String item, int durationInSeconds) {
        super(String.format("%s was visible after waiting for %d seconds", item, durationInSeconds));
    }
}
