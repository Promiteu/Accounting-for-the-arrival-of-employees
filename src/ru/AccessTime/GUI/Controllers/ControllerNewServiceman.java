package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.AccessTime.GUI.WorkController;


public class ControllerNewServiceman  {
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
    private Button bSaveNewS;

    @FXML
    private Button bExitNewS;

    public void setWorkController(WorkController workController) {
        this.workController = workController;
    }

    public Button getbSaveNewS() {
        return bSaveNewS;
    }
    public Button getbExitNewS() {
        return bExitNewS;
    }
    public void exitNewServicemanWin () {
        myStage = (Stage) bExitNewS.getScene().getWindow();
        myStage.close();

    }

}
