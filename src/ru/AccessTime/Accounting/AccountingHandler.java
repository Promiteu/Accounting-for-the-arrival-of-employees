package ru.AccessTime.Accounting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import ru.AccessTime.Serviceman.Serviceman;
import ru.AccessTime.WorkBD.WorkBase;

import java.text.SimpleDateFormat;

public class AccountingHandler {
    public static ObservableList <Serviceman> servicemenList = FXCollections.observableArrayList();
    public static ObservableList <Accounting> accountingList = FXCollections.observableArrayList();
    private Integer nomberAccouting = 0;
    private Double percents = 0.0;
    private String timeSignalDate;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.YYYY");


    public void newAccounting (ListView<Accounting > listOne, WorkBase workBase) {
        nomberAccouting++;
        Accounting accounting = new Accounting();
        accounting.setNomberAccouting(nomberAccouting);
        accountingList.add(accounting);
        workBase.saveAction(nomberAccouting, accounting.getDateAccounting(), percents, timeSignalDate);

    }

    public void setNomberAccouting(Integer nomberAccouting) {
        this.nomberAccouting = nomberAccouting;
    }
    public Integer getNomberAccouting() {
        return nomberAccouting;
    }

    public void setPercents(Double percents) {
        this.percents = percents;
    }

    public void setTimeSignalDate(String timeSignalDate) {
        this.timeSignalDate = timeSignalDate;
    }

    public AccountingHandler() {

    }
}
