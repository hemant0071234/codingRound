package exceptions;

public class PageNotReadyException extends RuntimeException {
    public PageNotReadyException(Object o, String context) {
        super(String.format("%s Page was not ready. '%s' was NOT true", o.getClass().getSimpleName(), context));
    }
}
