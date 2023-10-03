package Model;

import java.io.FileWriter;

/**
 * Класс, сохраняющий данные в файл.
 * Сохраняет в текущем каталоге.
 */
public class Saver {
    /**
     * Сохранить объект Human в файл.
     * Возникающие исключения пробрасываются выше по стеку вызовов.
     * @param human
     * @throws Exception
     */
    public void save(Human human) throws Exception{

        try (FileWriter fileWriter = new FileWriter(human.getLastName(), true)) {
            fileWriter.append(humanToString(human));
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Формирует строку для записи в файл
     * @param human
     * @return
     */
    private String humanToString(Human human) {
        return human.getFio() + " " + human.getBornString() + " " + human.getPhone() + " " + human.getGender();
    }
}
