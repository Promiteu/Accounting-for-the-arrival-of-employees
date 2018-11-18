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
import ru.AccessTime.WorkBD.WorkBase;

import java.io.IOException;

public class WorkController {
    public WorkBase workBase;

    private ControllerOneWin controllerOneWin;
    private ControllerTwoWin controllerTwoWin;
    private ControllerSettingWin controllerSettingWin;
    private ControllerNewServiceman controllerNewServiceman;

    private SignalBG eSinalBG;
    private ShowTimeNow showTimeNow = new ShowTimeNow();

    private Stage stageTwoWin;
    private Parent rootTwoWin;
    private Stage stageSettingWin;
    private Parent rootSettingWin;
    private Stage stageNewServiceman;
    private Parent rootNewServiceman;

    public WorkController(ControllerOneWin controllerOneWin) {
        this.controllerOneWin = controllerOneWin;
        workBase = new WorkBase();

    }


    public Stage getStageTwoWin() {
        return stageTwoWin;
    }
    public Stage getStageSettingWin() {
        return stageSettingWin;
    }
    public Stage getStageNewServiceman() {
        return stageNewServiceman;
    }
    public ShowTimeNow getShowTimeNow() {
        return showTimeNow;
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
        createTwoWin();
        showTimeNow.startShowTime(controllerTwoWin.getTimeNowShow());
        workBase.accountingHandler.newAccounting(controllerOneWin.getListOne(), workBase);
        workBase.creatNewTableAccointing(workBase.accountingHandler.getNomberAccouting());
        System.out.println(workBase.accountingHandler.getNomberAccouting());
    }
    public void showSettingWin() {
        createSettingWin();
        showTimeNow.startShowTime(controllerSettingWin.getTimeNowShow());




    }
    public void showNewServiseman () {
        createNewServicemanWin();
        stageNewServiceman.show();


    }

    public void createTwoWin() {
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
        stageTwoWin.setResizable(false);
        stageTwoWin.show();
    }
    public void createSettingWin() {
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
        stageSettingWin.setResizable(false);
        stageSettingWin.show();
    }
    public void createNewServicemanWin() {
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
        stageNewServiceman.setResizable(false);
    }





}
