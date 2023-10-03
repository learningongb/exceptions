package Exceptions;

/**
 * Исключение "ФИО не заполнено"
 */
public class ParseFioException extends Exception{
    public ParseFioException() {
        super("FIO not valid");
    }
}
