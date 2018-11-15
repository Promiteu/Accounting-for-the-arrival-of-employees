package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.AccessTime.Main;

import java.io.IOException;


public class ControllerSettingWin {

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
    private Text dateNow;

    @FXML
    private Button bSaveSetting;

    @FXML
    private Button bNewServicemanWin;

    @FXML
    private Button bExitSettingWin;

    public void  bSaveSetting() {

    }
    public void newServicemanWin() {
        Main.workController.showNewServiseman();
    }
    public void exitSetting() {
        Main.workController.getStageSettingWin().close();
    }

}
