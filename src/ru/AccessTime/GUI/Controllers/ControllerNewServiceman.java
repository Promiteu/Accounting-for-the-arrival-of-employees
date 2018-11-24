package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import ru.AccessTime.GUI.Dialogs.DialogManager;
import ru.AccessTime.GUI.WorkController;
import ru.AccessTime.Serviceman.Serviceman;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerNewServiceman  implements Initializable {
    public WorkController workController;

    private Stage myStage;
    @FXML
    private TextField numberStateNewS;

    @FXML
    private TextField positionNewS;

    @FXML
    private TextField surnameNewS;

    @FXML
    private TextField nameNewS;

    @FXML
    private TextField patronymicNewS;

    @FXML
    public TextField chPlus;

    @FXML
    private Button bSaveNewS;

    @FXML
    private Button bExitNewS;



    public void setWorkController(WorkController workController) {
        this.workController = workController;
    }


    public void creatNewServiceman () {


        if (numberStateNewS.getText().equals("")){
            DialogManager.showInfoDialog("Внимание", numberStateNewS.getPromptText());
        } else if (positionNewS.getText().equals("")){
            DialogManager.showInfoDialog("Внимание", positionNewS.getPromptText());
        } else if (surnameNewS.getText().equals("")){
            DialogManager.showInfoDialog("Внимание", surnameNewS.getPromptText());
        } else if (nameNewS.getText().equals("")){
            DialogManager.showInfoDialog("Внимание", nameNewS.getPromptText());
        } else if (patronymicNewS.getText().equals("")){
            DialogManager.showInfoDialog("Внимание", patronymicNewS.getPromptText());
        } else if (chPlus.getText().equals("")){
            DialogManager.showInfoDialog("Внимание", "Введите время на прибытие в формате 00:00");
        } else  {
            Serviceman serviceman = new Serviceman();
            String conditionDefault = serviceman.getCondition();
            workController.workBase.creatNewServisman(Integer.parseInt(numberStateNewS.getText()),
                    positionNewS.getText(),
                    surnameNewS.getText(),
                    nameNewS.getText(),
                    patronymicNewS.getText(),
                    conditionDefault,
                    chPlus.getText());
            workController.getControllerSettingWin().tableServicemenList.add(new Serviceman(Integer.parseInt(numberStateNewS.getText()), positionNewS.getText(), surnameNewS.getText(), nameNewS.getText(), patronymicNewS.getText(), conditionDefault,  chPlus.getText()));
            numberStateNewS.clear();
            positionNewS.clear();
            surnameNewS.clear();
            nameNewS.clear();
            patronymicNewS.clear();
            chPlus.clear();
        }


    }
    public void exitNewServicemanWin () {
        myStage = (Stage) bExitNewS.getScene().getWindow();
        myStage.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createEnterForNode();
    }
    public void createEnterForNode () {

        bSaveNewS.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                creatNewServiceman ();
            }
        });
        bExitNewS.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                exitNewServicemanWin ();
            }
        });
        chPlus.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                creatNewServiceman ();
            }
        });
        chPlus.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (!chPlus.getText().matches("(0[0-9])(:[0-6][0-9]){0,1}")) {
                    chPlus.setText("");

                }
            }
        });
    }

}
