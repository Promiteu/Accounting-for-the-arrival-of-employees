package ru.AccessTime;

public class Serviceman {       //Класс военнослужащих
    private int nomberState; //номер по штату
    private String position;    //Должность
    private String surname;     //Фамилия
    private String name;        //Имя
    private String patronymic;  //Отчество


    public Serviceman(String position, String surname, String name, String patronymic, int nomberState) {
        this.position = position;
        surname = surname;
        name = name;
        patronymic = patronymic;
        this.nomberState = nomberState;
    }
}
