package exceptions;

public class ElementNotVisibleException extends RuntimeException {
    public ElementNotVisibleException(String item, int durationInSeconds) {
        super(String.format("%s was not visible after waiting for %d seconds", item, durationInSeconds));
    }

}
