package ru.AccessTime.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.AccessTime.GUI.Controllers.ControllerNewServiceman;
import ru.AccessTime.GUI.Controllers.ControllerOneWin;
import ru.AccessTime.GUI.Controllers.ControllerSettingWin;
import ru.AccessTime.GUI.Controllers.ControllerTwoWin;
import ru.AccessTime.Main;

import java.io.IOException;

public class WorkController {
    private ControllerOneWin controllerOneWin;
    private ControllerTwoWin controllerTwoWin;
    private Stage stageTwoWin;
    private Parent rootTwoWin;
    private ControllerSettingWin controllerSettingWin;
    private Stage stageSettingWin;
    private Parent rootSettingWin;
    private ControllerNewServiceman controllerNewServiceman;
    private Stage stageNewServiceman;
    private Parent rootNewServiceman;

    public Stage getStageTwoWin() {
        return stageTwoWin;
    }
    public Stage getStageSettingWin() {
        return stageSettingWin;
    }
    public Stage getStageNewServiceman() {
        return stageNewServiceman;
    }

    public ControllerOneWin getControllerOneWin() {
        return controllerOneWin;
    }
    public ControllerTwoWin getControllerTwoWin() {
        return controllerTwoWin;
    }
    public ControllerSettingWin getControllerSettingWin() {
        return controllerSettingWin;
    }
    public ControllerNewServiceman getControllerNewServiceman() {
        return controllerNewServiceman;
    }

    public void showTwoWin () {
        stageTwoWin = new Stage();
        try {
            rootTwoWin = FXMLLoader.load(getClass().getResource("FXML/twoWin.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stageTwoWin.initModality(Modality.APPLICATION_MODAL);
        stageTwoWin.setTitle("Учет прибытия личного состава");
        stageTwoWin.setScene(new Scene(rootTwoWin));
        stageTwoWin.show();
    }
    public void showSetttibngWin () {
        stageSettingWin = new Stage();
        try {
            rootSettingWin = FXMLLoader.load(getClass().getResource("FXML/settingWin.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stageSettingWin.initModality(Modality.APPLICATION_MODAL);
        stageSettingWin.setTitle("Уточнение");
        stageSettingWin.setScene(new Scene(rootSettingWin));
        stageSettingWin.show();
    }
    public void showNewServiseman () {
        stageNewServiceman = new Stage();
        try {
            rootNewServiceman = FXMLLoader.load(getClass().getResource("FXML/newServiceman.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stageNewServiceman.setTitle("Создание нового военнослужащего");
        stageNewServiceman.setScene(new Scene(rootNewServiceman));
        stageNewServiceman.show();
    }
    public void closeOneWin () {

    }

    public WorkController() {
        this.controllerOneWin = new ControllerOneWin();
        this.controllerTwoWin = new ControllerTwoWin();
        this.controllerSettingWin = new ControllerSettingWin();
        this.controllerNewServiceman = new ControllerNewServiceman();
    }
}
