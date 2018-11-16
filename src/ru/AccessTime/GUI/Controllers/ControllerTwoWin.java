package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ru.AccessTime.GUI.WorkController;

public class ControllerTwoWin {
    public WorkController workController;
    @FXML
    private Text timeSignal;

    @FXML
    private TableView tableTwo;

    @FXML
    private TableColumn numberPP;

    @FXML
    private TableColumn FIO;

    @FXML
    private TableColumn timeArrival;

    @FXML
    private Text timeNowShow;

    @FXML
    private Text percents;

    @FXML
    private TextField numberState;

    @FXML
    public Button bClik;

    @FXML
    private Button bPrint;

    @FXML
    private Button bExitTwoWin;

    public void exitTwoWin() {
        workController.getStageTwoWin().close();
    }

    public void setWorkController(WorkController workController) {
        this.workController = workController;
    }
}
