package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.AccessTime.GUI.WorkController;



public class ControllerOneWin {
    public WorkController workController = new WorkController(this);
    public Stage myStage;

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



    @FXML public void startTwoWin() {
        workController.showTwoWin();
    }
    @FXML public void openP() {


    }
    @FXML public void showSettingWin() {
        workController.showSettingWin();
    }
    @FXML public void exitOneWin() {
       myStage = (Stage) bExitOne.getScene().getWindow();
       myStage.close();
       workController.getShowTimeNow().stopShowTime();
    }

    public Button getbStartTwoWin() {
        return bStartTwoWin;
    }
    public Button getbOpenP() {
        return bOpenP;
    }
    public Button getbShowSettingWin() {
        return bShowSettingWin;
    }
    public Button getbExitOne() {
        return bExitOne;
    }
    public Text getTimeNowShow() {
        return timeNowShow;
    }
    public TextField getTimeSignal() {
        return timeSignal;
    }
}
