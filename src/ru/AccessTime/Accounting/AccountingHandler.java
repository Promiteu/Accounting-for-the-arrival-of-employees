package ru.AccessTime.Accounting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import ru.AccessTime.Serviceman.Serviceman;
import ru.AccessTime.WorkBD.WorkBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

public class AccountingHandler {
    public static ObservableList <Serviceman> servicemenList = FXCollections.observableArrayList();

    public static TreeMap <Integer, String > listAccounting = new TreeMap<>();
    private Integer nomberAccouting = new Integer(0);

    public void newAccounting (ListView<String > listOne, WorkBase workBase) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.YYYY");
        Accounting accounting = new Accounting(date);
        nomberAccouting++;
        System.out.println(nomberAccouting);
        listAccounting.put(nomberAccouting,simpleDateFormat.format(accounting.getDateAccounting()));
        listOne.getItems().add(simpleDateFormat.format(accounting.getDateAccounting()));
        workBase.saveAction(nomberAccouting, simpleDateFormat.format(accounting.getDateAccounting()));

    }

    public void setNomberAccouting(Integer nomberAccouting) {
        this.nomberAccouting = nomberAccouting;
    }
    public Integer getNomberAccouting() {
        return nomberAccouting;
    }


    public AccountingHandler() {

    }
}
