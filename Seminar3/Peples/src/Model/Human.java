package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс описывает объект, для которого можно указать фио, дату рождения, номер телефона и пол.
 */
public class Human {

    /** Фамилия */
    private String lastName;
    /** Имя */
    private String firstName;
    /** Отчество */
    private String patronymic;
    /** Дата рождения */
    private Date born;
    /** Номер телефона */
    private Long phone;
    /** Пол */
    private char gender = '\0';

    /**
     * Устанавливает фамилию, имя, отчество из массива строк.
     * Автоматически приводит к правильному виду: первая буква прописная, остальные строчные
     * @param fio
     */
    public void setFio(String[] fio) {
        this.lastName = fio[0].substring(0, 1).toUpperCase() + fio[0].substring(1).toLowerCase();
        this.firstName = fio[1].substring(0, 1).toUpperCase() + fio[1].substring(1).toLowerCase();;
        this.patronymic = fio[2].substring(0, 1).toUpperCase() + fio[2].substring(1).toLowerCase();;
    }

    /**
     * Дата рождения в формате "дд.мм.гггг"
     * @return
     */
    public String getBornString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        return dateFormat.format(born);
    }

    public Human() {}

    @Override
    public String toString() {
        return "Human{" +
                "fio='" + getFio() + '\'' +
                ", born=" + getBornString() +
                ", phone=" + phone +
                ", gender=" + gender +
                '}';
    }

    public String getFio() {
        return lastName + " " + firstName + " " + patronymic;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
