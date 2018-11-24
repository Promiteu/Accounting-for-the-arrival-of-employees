package ru.AccessTime.Serviceman;

public class Serviceman {           // Класс военнослужащих


    private Integer nomberState;    // Номер по штату
    private String position;        // Должность
    private String surname;         // Фамилия
    private String name;            // Имя
    private String patronymic;      // Отчество
    private String condition = "On";       // Состояние
    private String chPlus;         // Время прибытия
    private String timeAcc;        // Время когда прибыл


    public Serviceman() {
    }

    public Serviceman(int nomberState, String position, String surname, String name, String patronymic, String condition, String chPlus) {
        this.nomberState = nomberState;
        this.position = position;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.condition = condition;
        this.chPlus = chPlus;

    }
    public Serviceman(int nomberState, String position, String surname, String name, String patronymic, String condition, String chPlus, String timeAcc) {
        this.nomberState = nomberState;
        this.position = position;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.condition = condition;
        this.chPlus = chPlus;
        this.timeAcc = timeAcc;

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
    public String getChPlus() {
        return chPlus;
    }
    public String getTimeAcc() {
        return timeAcc;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setTimeAcc(String  timeAcc) {
        this.timeAcc = timeAcc;
    }
    public void setNomberState(Integer nomberState) {
        this.nomberState = nomberState;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setChPlus(String chPlus) {
        this.chPlus = chPlus;
    }
}
