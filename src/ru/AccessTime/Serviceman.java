package ru.AccessTime;

public class Serviceman {       //Класс военнослужащих
    private int nomberState; //номер по штату
    private String position;    //Должность
    private String surname;     //Фамилия
    private String name;        //Имя
    private String patronymic;  //Отчество
    private float chPlus;       //время прибытия


    public Serviceman(String position, String surname, String name, String patronymic, int nomberState, float chPlus) {
        this.position = position;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.chPlus = chPlus;
        this.nomberState = nomberState;
    }
}
