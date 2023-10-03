package View;

import java.util.Scanner;

/**
 * Класс ввода данных через консоль
 */
public class ConsoleView implements IView {

    @Override
    public String inputString() {
        System.out.println("Введите фамилию, имя, отчество, дату рождения, номер телефона, пол в любом порядке через пробел:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
