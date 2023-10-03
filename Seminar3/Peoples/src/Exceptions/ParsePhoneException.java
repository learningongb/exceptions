package Exceptions;

/**
 * Исключение "Номер телефона не заполнен"
 */
public class ParsePhoneException extends Exception {
    public ParsePhoneException() {
        super("Phone not valid");
    }
}
