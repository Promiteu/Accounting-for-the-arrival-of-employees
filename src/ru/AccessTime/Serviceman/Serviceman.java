package ru.AccessTime.Serviceman;

public class Serviceman {           // Класс военнослужащих
    private Integer nomberState;    // Номер по штату
    private String position;        // Должность
    private String surname;         // Фамилия
    private String name;            // Имя
    private String patronymic;      // Отчество
    private String condition;       // Состояние
    private Integer chPlus;         // Время прибытия
    private Integer timeAcc;        // Время когда прибыл


    public Serviceman() {
    }

    public Serviceman(int nomberState, String position, String surname, String name, String patronymic, String condition, Integer chPlus) {
        this.nomberState = nomberState;
        this.position = position;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.condition = condition;
        this.chPlus = chPlus;

    }

    public Integer getNomberState() {
        return nomberState;
    }

    public String getPosition() {
        return position;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getCondition() {
        return condition;
    }

    public Integer getChPlus() {
        return chPlus;
    }

    public Integer getTimeAcc() {
        return timeAcc;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
