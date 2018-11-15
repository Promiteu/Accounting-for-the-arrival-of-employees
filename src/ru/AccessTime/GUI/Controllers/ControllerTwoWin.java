package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.AccessTime.Main;

import java.io.IOException;

public class ControllerTwoWin {
    @FXML
    private Text timeSignal;

    @FXML
    private TableView tableTwo;

    @FXML
    private TableColumn numberPP;

    @FXML
    private TableColumn FIO;

    @FXML
    private TableColumn timeArrival;

    @FXML
    private Text timeNowShow;

    @FXML
    private Text percents;

    @FXML
    private TextField numberState;

    @FXML
    private Button bClik;

    @FXML
    private Button bPrint;

    @FXML
    private Button bExitTwoWin;

    public void exitTwoWin() {
        Main.workController.getStageTwoWin().close();
    }
}
