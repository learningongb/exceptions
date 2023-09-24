import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введенная строка: " + getString());
    }

    /**
     * Запрашивает у пользователя ввод строки в возвращает введенную строку.
     * Если строка пустая, выбрасывает исключение "Вводить пустую строку нельзя".
     * @return введенная строка
     * @throws Exception
     */
    private static String getString() throws Exception{
        System.out.println("Введите не пустую строку:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.isEmpty())
            throw new Exception("Вводить пустую строку нельзя");
        return str;

    }
}