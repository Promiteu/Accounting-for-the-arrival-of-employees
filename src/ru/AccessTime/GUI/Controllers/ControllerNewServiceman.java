package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.AccessTime.Main;

import java.io.IOException;


public class ControllerNewServiceman {

    @FXML
    private TextField numberStateNewS;

    @FXML
    private TextField positionNewS;

    @FXML
    private TextField surnameNewS;

    @FXML
    private TextField nameNewS;

    @FXML
    private TextField patronymicNewS;

    @FXML
    private Button bSaveNewS;

    @FXML
    private Button bExitNewS;

    public void exitNewServicemanWin () {
        Main.workController.getStageNewServiceman().close();
    }

}
