package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import ru.AccessTime.GUI.WorkController;


public class ControllerSettingWin  {
    public WorkController workController;

    @FXML
    private Text dateUpdateShow;

    @FXML
    private TableView tableSetting;

    @FXML
    private TableColumn tableSettingPP;

    @FXML
    private TableColumn settingFIO;

    @FXML
    private TableColumn settingCondition;

    @FXML
    private Text timeNowShow;

    @FXML
    public Button bSaveSetting;

    @FXML
    private Button bNewServicemanWin;

    @FXML
    private Button bExitSettingWin;

    public void  bSaveSetting() {

    }
    public void newServicemanWin() {
        workController.showNewServiseman();
    }
    public void exitSetting() {
        workController.getStageSettingWin().close();

    }

    public void setWorkController(WorkController workController) {
        this.workController = workController;
    }

    public Button getbSaveSetting() {
        return bSaveSetting;
    }
    public Button getbNewServicemanWin() {
        return bNewServicemanWin;
    }
    public Button getbExitSettingWin() {
        return bExitSettingWin;
    }
    public Text getTimeNowShow() {
        return timeNowShow;
    }
}
