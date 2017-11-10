package exceptions;

public class JavascriptException extends RuntimeException {
    public JavascriptException(String context) {
        super(String.format("The Javascript execution threw an error: %s", context));
    }
}

