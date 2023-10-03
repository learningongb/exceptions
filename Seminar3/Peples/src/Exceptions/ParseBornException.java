package Exceptions;

/**
 * Исключение "Дата не заполнена"
 */
public class ParseBornException extends Exception{
    public ParseBornException() {
        super("Date not valid");
    }
}
