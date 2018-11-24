package ru.AccessTime.WorkBD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.AccessTime.Accounting.Accounting;
import ru.AccessTime.Accounting.AccountingHandler;
import ru.AccessTime.Serviceman.Serviceman;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkBase {
    public AccountingHandler accountingHandler = new AccountingHandler();
    private ConnectionBD connectionBD;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public WorkBase() {
        connectionBD = new ConnectionBD();
        creatTableServiceman();
        creatTableAccounting();
        creatNewTableAccointing();
        lodingAccountingHandler();
        lodingServicemanList ();

    }

    private void creatTableServiceman() {
        try {
            statement = connectionBD.getConnection().createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS SrevicMan (\n" +
                    "    NomberState INTEGER     UNIQUE,\n" +
                    "    Position    STRING (25) UNIQUE,\n" +
                    "    Surname     STRING (30),\n" +
                    "    Name        STRING,\n" +
                    "    Patronymic  STRING,\n" +
                    "    Condition   STRING,\n" +
                    "    chPlus      STRING\n" +
                    ");\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void creatTableAccounting() {
        try {
            statement = connectionBD.getConnection().createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Accounting (\n" +
                    "    Nomber   INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                    "                     UNIQUE,\n" +
                    "    Date     INTEGER,\n" +
                    "    percents DOUBLE,\n" +
                    "    time     STRING\n" +
                    ");\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void creatNewTableAccointing() {
        try {
            statement = connectionBD.getConnection().createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS NewAccounting (\n" +
                    "    Nomber      INTEGER REFERENCES Accounting (Nomber),\n" +
                    "    nomberState INTEGER,\n" +
                    "    position    STRING,\n" +
                    "    surname     STRING,\n" +
                    "    name        STRING,\n" +
                    "    patronymic  STRING,\n" +
                    "    condition   STRING,\n" +
                    "    chPlus      TIME,\n" +
                    "    timeAcc     TIME\n" +
                    ");\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void lodingAccountingHandler() {
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement("SELECT * FROM Accounting");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                accountingHandler.accountingList.add(new Accounting(rs.getInt(1), rs.getLong(2), rs.getDouble(3), rs.getString(4)));
                accountingHandler.setNomberAccouting(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveAction (int nomber, long date, Double percents, String timeSignalDate) {
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement("INSERT INTO Accounting (Nomber, Date, percents, time) VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, nomber);
            preparedStatement.setLong(2, date);
            preparedStatement.setDouble(3, percents);
            preparedStatement.setString(4, timeSignalDate);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAction (int nomber, Double percents) {
        try {
            statement = connectionBD.getConnection().createStatement();
            statement.executeUpdate("UPDATE Accounting SET `percents` = " + percents + " WHERE `Nomber` = " + nomber + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void creatNewServisman (Integer nomberState, String position, String surname, String name, String patronymic, String condition, String chPlus) {
        try {
                preparedStatement = connectionBD.getConnection().prepareStatement("INSERT INTO SrevicMan (NomberState, Position, Surname, Name, Patronymic, Condition, chPlus) VALUES(?, ?, ?, ?, ?, ?, ?);");
                preparedStatement.setInt(1, nomberState);
                preparedStatement.setString(2, position);
                preparedStatement.setString(3, surname);
                preparedStatement.setString(4, name);
                preparedStatement.setString(5, patronymic);
                preparedStatement.setString(6, condition);
                preparedStatement.setString(7, chPlus);
                preparedStatement.addBatch();
                preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateServisman (Serviceman serviceman) {
        try {
            statement = connectionBD.getConnection().createStatement();
            statement.executeUpdate("UPDATE SrevicMan SET Position = '" + serviceman.getPosition()
                    + "', Surname = '" + serviceman.getSurname()
                    + "', Name = '" + serviceman.getName()
                    + "', Patronymic = '" + serviceman.getPatronymic()
                    + "', Condition = '" + serviceman.getCondition()
                    + "' WHERE NomberState = " + serviceman.getNomberState() + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteServisman (Serviceman serviceman) {
        try {
            statement = connectionBD.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM SrevicMan WHERE NomberState = " + serviceman.getNomberState() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAc (Accounting accounting) {
        try {
            statement = connectionBD.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM NewAccounting WHERE Nomber = " + accounting.getNomberAccouting() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connectionBD.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM Accounting WHERE Nomber = " + accounting.getNomberAccouting() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void lodingServicemanList () {
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement("SELECT * FROM SrevicMan");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                AccountingHandler.servicemenList.add(new Serviceman(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void lodingTableNewAccounting (Integer integer, Serviceman servicemen) {
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement("INSERT INTO NewAccounting (Nomber, nomberState, position, surname, name, patronymic, condition, chPlus, timeAcc) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
                preparedStatement.setInt(1, integer);
                preparedStatement.setInt(2, servicemen.getNomberState());
                preparedStatement.setString(3, servicemen.getPosition());
                preparedStatement.setString(4, servicemen.getSurname());
                preparedStatement.setString(5, servicemen.getName());
                preparedStatement.setString(6, servicemen.getPatronymic());
                preparedStatement.setString(7, servicemen.getCondition());
                preparedStatement.setString(8, servicemen.getChPlus());
                preparedStatement.setString(9, servicemen.getTimeAcc());
                preparedStatement.addBatch();
                preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ObservableList <Serviceman> openAccountingExcel (Integer nomber) {
        ObservableList <Serviceman> openAccountingExcel = FXCollections.observableArrayList();
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement("SELECT nomberState, position, surname, name, patronymic, condition, chPlus, timeAcc FROM NewAccounting WHERE Nomber =" + nomber + ";");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                openAccountingExcel.add(new Serviceman(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return openAccountingExcel;
    }


}