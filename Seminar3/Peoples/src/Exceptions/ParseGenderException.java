package Exceptions;

/**
 * Исключение "Пол не заполнен"
 */

public class ParseGenderException extends Exception{
    public ParseGenderException() {
        super("Gender not valid");
    }
}
