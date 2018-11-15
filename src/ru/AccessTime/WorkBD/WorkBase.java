package ru.AccessTime.WorkBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkBase {
    private ConnectionBD connectionBD;
    private Statement newTable;
    private PreparedStatement newServiceman;
    private PreparedStatement updateServiceman;



    public WorkBase() {
        connectionBD = new ConnectionBD();
        creatNewTable();

    }

    private void creatNewTable() {
        try {
            newTable = connectionBD.getConnection().createStatement();
            newTable.executeUpdate("CREATE TABLE IF NOT EXISTS SrevicMan (\n" +
                    "    NomberState INTEGER   NOT NULL\n" +
                    "                          UNIQUE,\n" +
                    "    Position    TEXT (25) NOT NULL\n" +
                    "                          UNIQUE,\n" +
                    "    Surname     TEXT (30) NOT NULL,\n" +
                    "    Name        TEXT      NOT NULL,\n" +
                    "    Patronymic  TEXT      NOT NULL\n" +
                    ");\n");
            System.out.println("Запрос отправлен"); //IF NOT EXISTS
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creatNewServisman (int nomberState, String position, String surname, String name, String patronymic) {

        try {
            newServiceman = connectionBD.getConnection().prepareStatement("SELECT NomberState FROM SrevicMan WHERE NomberState = " + nomberState);
            ResultSet rs = newServiceman.executeQuery();
            if (!rs.next()) {
                newServiceman = connectionBD.getConnection().prepareStatement("INSERT INTO SrevicMan (NomberState, Position, Surname, Name, Patronymic) VALUES(?, ?, ?, ?, ?);");
                newServiceman.setInt(1, nomberState);
                newServiceman.setString(2, position);
                newServiceman.setString(3, surname);
                newServiceman.setString(4, name);
                newServiceman.setString(5, patronymic);
                newServiceman.addBatch();
                newServiceman.executeBatch();
            } else System.out.println("Клиент существует");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateServisman () {
        //updateServiceman = connectionBD.getConnection().prepareStatement();
    } // требует доработки
}