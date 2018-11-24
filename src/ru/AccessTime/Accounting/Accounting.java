package ru.AccessTime.Accounting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Accounting {
    private long dateAccounting;
    private Integer nomberAccouting = 0;
    private Double percents = 0.0;
    private String timeSignalDate;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.YYYY");

    public Accounting() {
        this.dateAccounting = new Date().getTime();
    }

    public Accounting(Integer nomberAccouting, long dateAccounting, Double percents, String timeSignalDate) {
        this.dateAccounting = dateAccounting;
        this.nomberAccouting = nomberAccouting;
        this.percents = percents;
        this.timeSignalDate = timeSignalDate;
    }

    public long getDateAccounting() {
        return dateAccounting;
    }
    public Integer getNomberAccouting() {
        return nomberAccouting;
    }
    public Double getPercents() {
        return percents;
    }
    public String getTimeSignalDate() {
        return timeSignalDate;
    }

    public void setDateAccounting(long dateAccounting) {
        this.dateAccounting = dateAccounting;
    }
    public void setNomberAccouting(Integer nomberAccouting) {
        this.nomberAccouting = nomberAccouting;
    }
    public void setPercents(Double percents) {
        this.percents = percents;
    }
    public void setTimeSignalDate(String timeSignalDate) {
        this.timeSignalDate = timeSignalDate;
    }

    @Override
    public String toString() {
        return (simpleDateFormat.format(new Date(dateAccounting)).toString());
    }
}
