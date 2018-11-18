package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.AccessTime.Accounting.AccountingHandler;
import ru.AccessTime.GUI.SignalBG;
import ru.AccessTime.GUI.WorkController;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class ControllerOneWin implements Initializable{
    public WorkController workController = new WorkController(this);
    public Stage myStage;
    private String signal;
    private String timeSignalDate;

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
    private ChoiceBox choiceBoxOneWin;

    @FXML
    private TextField timeSignal;

    @FXML
    private ListView <String > listOne;

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
        workController.showTwoWin();
        timeSignalDate = timeSignal.getText();
        workController.getControllerTwoWin().getTimeSignal().setText(timeSignalDate);

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
    public ChoiceBox<SignalBG> getChoiceBoxOneWin() {
        return choiceBoxOneWin;
    }
    public ListView<String> getListOne() {
        return listOne;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxOneWin.getItems().addAll(SignalBG.POVISHINNAY.getName(), SignalBG.VOENNAY_OPASNOST.getName(), SignalBG.POLNAIY.getName());
        createEnterForNode();
        listAccounting(AccountingHandler.listAccounting);
    }

    public void createEnterForNode() {
        workController.getShowTimeNow().startShowTime(timeNowShow);
        bStartTwoWin.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                workController.showTwoWin();
            }
        });
        //bOpenP.setOnKeyPressed();                                          //прописать после создания метода ОТКРЫТЬ
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
    }

    private void listAccounting (TreeMap <Integer, String > list) {
        for (Map.Entry <Integer, String> o : list.entrySet()) {
            listOne.getItems().add(o.getValue());
        }
    }
}
