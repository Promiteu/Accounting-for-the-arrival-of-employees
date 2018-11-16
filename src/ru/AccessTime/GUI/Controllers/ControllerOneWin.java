package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.AccessTime.GUI.WorkController;



public class ControllerOneWin {
    public WorkController workController = new WorkController(this);
    Stage myStage;

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
        workController.showTwoWin();
    }
    @FXML private void openP() {


    }
    @FXML private void showSettingWin() {
        workController.showSettingWin();
    }
    @FXML private void exitOneWin() {
       myStage = (Stage) bStartTwoWin.getScene().getWindow();
       myStage.close();

    }

}
