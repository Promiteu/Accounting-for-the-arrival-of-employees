package ru.AccessTime.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.AccessTime.GUI.Controllers.ControllerNewServiceman;
import ru.AccessTime.GUI.Controllers.ControllerOneWin;
import ru.AccessTime.GUI.Controllers.ControllerSettingWin;
import ru.AccessTime.GUI.Controllers.ControllerTwoWin;

import java.io.IOException;

public class WorkController {
    private ControllerOneWin controllerOneWin;
    private ControllerTwoWin controllerTwoWin;
    private ControllerSettingWin controllerSettingWin;
    private ControllerNewServiceman controllerNewServiceman;

    private ShowTimeNow showTimeNow = new ShowTimeNow();

    private Stage stageTwoWin;
    private Parent rootTwoWin;
    private Stage stageSettingWin;
    private Parent rootSettingWin;
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

    public void showTwoWin () {
        stageTwoWin = new Stage();
        FXMLLoader loaderTwoWin = new FXMLLoader();
        loaderTwoWin.setLocation(getClass().getResource("FXML/twoWin.fxml"));
        try {
            rootTwoWin = loaderTwoWin.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controllerTwoWin = loaderTwoWin.getController();
        controllerTwoWin.setWorkController(this);
        stageTwoWin.setTitle("Учет прибытия");
        stageTwoWin.initModality(Modality.APPLICATION_MODAL);
        stageTwoWin.setScene(new Scene(rootTwoWin));
        stageTwoWin.show();
        showTimeNow.startShowTime(controllerTwoWin.getTimeNowShow());

    }
    public void showSettingWin() {
        stageSettingWin = new Stage();
        FXMLLoader loaderSettingWin = new FXMLLoader();
        loaderSettingWin.setLocation(getClass().getResource("FXML/settingWin.fxml"));
        try {
            rootSettingWin = loaderSettingWin.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controllerSettingWin = loaderSettingWin.getController();
        controllerSettingWin.setWorkController(this);
        stageSettingWin.setTitle("Уточнение");
        stageSettingWin.setScene(new Scene(rootSettingWin));
        stageSettingWin.show();
        showTimeNow.startShowTime(controllerSettingWin.getTimeNowShow());



    }
    public void showNewServiseman () {
        stageNewServiceman = new Stage();
        FXMLLoader loaderNewServiceManWin = new FXMLLoader();
        loaderNewServiceManWin.setLocation(getClass().getResource("FXML/newServiceman.fxml"));
        try {
            rootNewServiceman = loaderNewServiceManWin.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controllerNewServiceman = loaderNewServiceManWin.getController();
        controllerNewServiceman.setWorkController(this);
        stageNewServiceman.setTitle("Уточнение");
        stageNewServiceman.initModality(Modality.APPLICATION_MODAL);
        stageNewServiceman.setScene(new Scene(rootNewServiceman));
        stageNewServiceman.show();

    }

    public void inicializOneWin () {

        showTimeNow.startShowTime(controllerOneWin.getTimeNowShow());
        controllerOneWin.getbStartTwoWin().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                showTwoWin();
            }
        });
        controllerOneWin.getbOpenP();                                           //прописать после создания метода ОТКРЫТЬ
        controllerOneWin.getbShowSettingWin().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                showSettingWin();
            }
        });
        controllerOneWin.getbExitOne().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                controllerOneWin.exitOneWin();
                }
        });
        controllerOneWin.getTimeSignal().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {showTwoWin();}
        });
    }

    public ShowTimeNow getShowTimeNow() {
        return showTimeNow;
    }

    public WorkController(ControllerOneWin controllerOneWin) {
        this.controllerOneWin = controllerOneWin;

    }


}
