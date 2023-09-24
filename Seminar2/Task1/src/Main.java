import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введенное число: " + getNumber());
    }

    /**
     * Запрашивает у пользователя число с плавающей точкой.
     * Если введена не правильная строка, ввод будет запрошен снова, пока пользователь не введет
     * правильное число.
      * @return введенное число
     */
    public static float getNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean needNextScan = true;
        float number = 0;
        System.out.println("Введите дробное число (целая часть, дробная часть):");
        do {
            try {
                number = scanner.nextFloat();
                needNextScan = false;
            }
            catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Неверный формат числа. Попробуйте еще:");
            }

        } while (needNextScan);
        return number;
    }
}