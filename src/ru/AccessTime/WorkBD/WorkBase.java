package ru.AccessTime.WorkBD;

import ru.AccessTime.Accounting.AccountingHandler;
import ru.AccessTime.Serviceman.Serviceman;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkBase {
    public AccountingHandler accountingHandler = new AccountingHandler();
    private ConnectionBD connectionBD;
    private Statement newTable;
    private PreparedStatement newServiceman;

    public WorkBase() {
        connectionBD = new ConnectionBD();
        creatTableServiceman();
        creatTableAccounting();
        lodingAccointingHandler();
        lodingServicemanList ();

    }

    private void creatTableServiceman() {
        try {
            newTable = connectionBD.getConnection().createStatement();
            newTable.executeUpdate("CREATE TABLE IF NOT EXISTS SrevicMan (\n" +
                    "    NomberState INTEGER     UNIQUE,\n" +
                    "    Position    STRING (25) UNIQUE,\n" +
                    "    Surname     STRING (30),\n" +
                    "    Name        STRING,\n" +
                    "    Patronymic  STRING,\n" +
                    "    Condition   STRING,\n" +
                    "    chPlus      INTEGER\n" +
                    ");\n");
            System.out.println("Таблица создалась!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void creatTableAccounting() {
        try {
            newTable = connectionBD.getConnection().createStatement();
            newTable.executeUpdate("CREATE TABLE IF NOT EXISTS Accounting (\n" +
                    "    Nomber INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                    "                   UNIQUE,\n" +
                    "    Date   TEXT\n" +
                    ");\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void creatNewTableAccointing(Integer integer) {
        try {
            newTable = connectionBD.getConnection().createStatement();
            newTable.executeUpdate("CREATE TABLE IF NOT EXISTS NewAccounting (\n" +
                    "    Nomber      INTEGER REFERENCES Accounting (Nomber),\n" +
                    "    nomberState INTEGER,\n" +
                    "    position    STRING,\n" +
                    "    FIO         STRING,\n" +
                    "    condition   STRING,\n" +
                    "    chPlus      TIME,\n" +
                    "    timeAcc     TIME\n" +
                    ");\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            newServiceman = connectionBD.getConnection().prepareStatement("INSERT INTO NewAccounting (Nomber, nomberState, position, FIO, condition, chPlus, timeAcc) VALUES(?, ?, ?, ?, ?, ?, ?);");
            newServiceman.setInt(1, integer);
            newServiceman.setInt(2, 0);
            newServiceman.setString(3, null);
            newServiceman.setString(4, null);
            newServiceman.setString(5, null);
            newServiceman.setString(6, null);
            newServiceman.setString(7, null);
            newServiceman.addBatch();
            newServiceman.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void lodingAccointingHandler () {
        try {
            newServiceman = connectionBD.getConnection().prepareStatement("SELECT * FROM Accounting");
            ResultSet rs = newServiceman.executeQuery();
            while (rs.next()){
                accountingHandler.listAccounting.put(rs.getInt(1), rs.getString(2));
                accountingHandler.setNomberAccouting(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveAction (int nomber, String date) {
        try {
            newServiceman = connectionBD.getConnection().prepareStatement("INSERT INTO Accounting (Nomber, Date) VALUES(?, ?);");
            newServiceman.setInt(1, nomber);
            newServiceman.setString(2, date);
            newServiceman.addBatch();
            newServiceman.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void creatNewServisman (Integer nomberState, String position, String surname, String name, String patronymic, Integer chPlus) {
        try {
                newServiceman = connectionBD.getConnection().prepareStatement("INSERT INTO SrevicMan (NomberState, Position, Surname, Name, Patronymic, Condition, chPlus) VALUES(?, ?, ?, ?, ?, ?, ?);");
                newServiceman.setInt(1, nomberState);
                newServiceman.setString(2, position);
                newServiceman.setString(3, surname);
                newServiceman.setString(4, name);
                newServiceman.setString(5, patronymic);
                newServiceman.setString(6, "On");
                newServiceman.setInt(7, chPlus);
                newServiceman.addBatch();
                newServiceman.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void lodingServicemanList () {
        try {
            newServiceman = connectionBD.getConnection().prepareStatement("SELECT * FROM SrevicMan");
            ResultSet rs = newServiceman.executeQuery();
            while (rs.next()){
                AccountingHandler.servicemenList.add(new Serviceman(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7) ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateServisman () {
        //updateServiceman = connectionBD.getConnection().prepareStatement();
    } // требует доработки
}