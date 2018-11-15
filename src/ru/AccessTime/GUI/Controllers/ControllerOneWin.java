package ru.AccessTime.GUI.Controllers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.AccessTime.Main;

import static java.lang.String.valueOf;


public class ControllerOneWin {
    Stage myStage;

    @FXML
    private Text timeNow;

    @FXML
    private Text timeNowShow;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem menuTwoWin;

    @FXML
    private MenuItem menuSetting;

    @FXML
    private MenuItem menuExit;

    @FXML
    private MenuItem menuInfo;

    @FXML
    private TextField timeSignal;

    @FXML
    private ListView listOne;

    @FXML
    private Button bStartTwoWin;

    @FXML
    private Button bOpenP;

    @FXML
    private Button bShowSettingWin;

    @FXML
    private Button bExitOne;

    @FXML private void startTwoWin() {
        Main.workController.showTwoWin();
    }
    @FXML private void openP() {


    }
    @FXML private void showSettingWin() {
        Main.workController.showSetttibngWin();
    }
    @FXML private void exitOne() {
       myStage = (Stage) bStartTwoWin.getScene().getWindow();
       myStage.close();

    }
}
