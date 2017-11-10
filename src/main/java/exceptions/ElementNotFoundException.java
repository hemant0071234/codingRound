package exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String context, Integer durationInSeconds) {
        super(String.format("Element '%s' was not found after waiting for %d seconds", context, durationInSeconds));
    }

    public ElementNotFoundException(String context) {
        super(String.format("Element was not found %s", context));
    }
}
