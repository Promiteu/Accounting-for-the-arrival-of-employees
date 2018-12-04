package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerInf {

    @FXML
    private Button btnOk;


    public void exitInfWin () {
        Stage myStage = (Stage) btnOk.getScene().getWindow();
        myStage.close();

    }
}
