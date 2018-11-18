package ru.AccessTime.Accounting;

import java.util.Date;

public class Accounting {
    private Date dateAccounting;

    public Accounting(Date dateAccounting) {
        this.dateAccounting = dateAccounting;
    }

    public Date getDateAccounting() {
        return dateAccounting;
    }
}
