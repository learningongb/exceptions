import Exceptions.ParseBornException;
import Exceptions.ParseFioException;
import Exceptions.ParseGenderException;
import Exceptions.ParsePhoneException;
import Model.Human;
import Model.Saver;
import View.IView;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Основной класс, реализующий ввод данных и парсинг введенной строки.
 */
public class InputController {

    /** Объект, через который идет ввод данных */
    IView view;
    /** Объект, который сохраняет введенные данные */
    Saver saver;

    public InputController(IView view, Saver saver) {
        this.view = view;
        this.saver = saver;
    }

    /**
     * Ввод данных от пользователя, парсинг введенных данных и их запись в файл.
     * Метод останавливается при корректной записи введенных данных или возникновении исключения.
     */
    public void run() {
        String str = "";
        Human human;

        /** Input string */
        while (str.isEmpty()) {
            str = view.inputString();
            if (checkFormat(str) < 0) {
                str = "";
                continue;
            }

            /** Parse string */
            try {
                human = humanFromString(str);
            } catch (Exception e ) {
                System.out.println("Ошибка разбора строки параметров:");
                e.printStackTrace();
                break;
            }

            /** Save to file */
            try {
                saver.save(human);
            } catch (Exception e) {
                System.out.println("Ошибка при сохранении в файл:");
                e.printStackTrace();
                break;
            }

            System.out.println("Данные записаны в файл");

        }
    }

    /**
     * Проверяет, что строка соответствует ожидаемому формату.
     * Ожидаемый формат - 6 слов, разделенных пробелами.
     * @param str
     * @return
     */
    private int checkFormat(String str) {
        String[] words = str.split(" ");
        if (words.length != 6) return -1;
        return 0;
    }

    /**
     * Заполняет экземпляр Human из строки данных
     * @param str
     * @return
     * @throws Exception
     */
    private Human humanFromString (String str) throws Exception {
        Human human = new Human();
        getBornDate(str, human);
        getGender(str, human);
        getPhone(str, human);
        getFIO(str, human);

        return human;
    }

    /**
     * Заполняет дату рождения из строки данных
     * @param str
     * @param human
     * @throws ParseBornException
     */
    private void getBornDate(String str, Human human) throws ParseBornException {

        Pattern pattern = Pattern.compile("\\d{1,2}\\.\\d{2}\\.(19|20)\\d{2}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
            try {
                human.setBorn(new SimpleDateFormat("dd.mm.yyyy", Locale.ENGLISH).parse(str.substring(matcher.start(), matcher.end())));
            } catch (Exception e) {}
        if (human.getBorn() == null)
            throw new ParseBornException();
    }

    /**
     * Заполняет пол из строки данных
     * @param str
     * @param human
     * @throws ParseGenderException
     */
    private void getGender(String str, Human human) throws ParseGenderException {
        Pattern pattern = Pattern.compile("\\b[fm]\\b");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
            human.setGender(str.charAt(matcher.start()));
        if (human.getBorn() == null)
            throw new ParseGenderException();
    }

    /**
     * Заполняет номер телефона из строки данных
     * @param str
     * @param human
     * @throws ParsePhoneException
     */
    private void getPhone(String str, Human human) throws ParsePhoneException {
        Pattern pattern = Pattern.compile("\\d{7,11}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find())
            human.setPhone(Long.parseLong(str.substring(matcher.start(), matcher.end())));
        if (human.getBorn() == null)
            throw new ParsePhoneException();
    }

    /**
     * Заполняет фио из строки данных
     * @param str
     * @param human
     * @throws ParseFioException
     */
    private void getFIO(String str, Human human) throws ParseFioException {
        Pattern pattern = Pattern.compile("\\b([a-zA-Zа-яА-Я]{2,}) ([a-zA-Zа-яА-Я]{2,}) ([a-zA-Zа-яА-Я]{2,})\\b");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String[] fio = new String[3];
            fio[0] = matcher.group(1);
            fio[1] = matcher.group(2);
            fio[2] = matcher.group(3);
            human.setFio(fio);
        }
        if (human.getBorn() == null)
            throw new ParseFioException();
    }

}
