package ru.AccessTime.GUI.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.AccessTime.Accounting.Accounting;
import ru.AccessTime.Accounting.AccountingHandler;
import ru.AccessTime.GUI.Dialogs.DialogManager;
import ru.AccessTime.GUI.WorkController;
import ru.AccessTime.Serviceman.Serviceman;
import ru.AccessTime.WorkExcels.WorkExcel;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerOneWin implements Initializable{
    public WorkController workController = new WorkController(this);
    public Stage myStage;
    private String timeSignalDate;
    private WorkExcel workExcel = new WorkExcel();
    private String  dateNow;

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
    private ListView <Accounting> listOne;

    @FXML
    private Button bStartTwoWin;

    @FXML
    private Button bOpenP;

    @FXML
    private Button bShowSettingWin;

    @FXML
    private Button bExitOne;

    public ControllerOneWin() {
    }

    @FXML public void startTwoWin() {
        if (!timeSignal.getText().equals("")) {
            timeSignalDate = timeSignal.getText();
            workController.showTwoWin();
            workController.getControllerTwoWin().setDate(dateNow);
            workController.getControllerTwoWin().getTimeSignal().setText(timeSignalDate);
        } else DialogManager.showInfoDialog("Ошибка", "Введите время подачи сигнала в формате 00:00");
    }
    @FXML public void showSettingWin() {
        workController.showSettingWin();
    }
    @FXML public void showInfWin () {
        workController.showInformation();
    }
    @FXML public void exitOneWin() {
       myStage = (Stage) bExitOne.getScene().getWindow();
       myStage.close();
       workController.getShowTimeNow().stopShowTime();
    }


    public void openAccountingWordExcel () {
        Accounting accounting = listOne.getSelectionModel().getSelectedItem();
        if (accounting != null)
        {ObservableList <Serviceman> open = workController.workBase.openAccountingExcel(accounting.getNomberAccouting());
        System.out.println(open);
        workController.getWorkExcel().creatNewExcel(open, accounting.getTimeSignalDate(), dateNow, String.valueOf(accounting.getPercents()) + "%");
        } else DialogManager.showErrorDialog("Ошибка", "Не выбрана дата проведения сбора личного состава!");
    }

    public ListView<Accounting > getListOne() {
        return listOne;
    }
    public String getTimeSignalDate() {
        return timeSignalDate;
    }
    public TextField getTimeSignal() {
        return timeSignal;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createEnterForNode();
        listAccounting(AccountingHandler.accountingList);
    }

    public void createEnterForNode() {
        workController.getShowTimeNow().startShowTime(timeNowShow);
        bStartTwoWin.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                workController.showTwoWin();
            }
        });
        bOpenP.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                openAccountingWordExcel ();
            }

        });
        bShowSettingWin.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                showSettingWin();
            }
        });
        bExitOne.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                exitOneWin();
            }
        });
        timeSignal.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {workController.getShowTimeNow();}
        });
        timeSignal.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (!timeSignal.getText().matches("(0[0-9]|1[0-9]|2[0-4])(:[0-6][0-9]){0,1}")) {
                    timeSignal.setText("");

                }
            }
        });
    }


    private void listAccounting (ObservableList<Accounting> accountingList) {
        listOne.setItems(accountingList);
        dateNow ();
    }

    public void dateNow () {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.YYYY");
        dateNow = simpleDateFormat.format(date).toString();

    }


}
