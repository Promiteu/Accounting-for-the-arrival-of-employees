package ru.AccessTime.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ru.AccessTime.GUI.WorkController;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTwoWin  implements Initializable{
    public WorkController workController;
    private String signal;
    private String timeSignalDate;

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

    public Button getbClik() {
        return bClik;
    }
    public Button getbPrint() {
        return bPrint;
    }
    public Button getbExitTwoWin() {
        return bExitTwoWin;
    }
    public Text getTimeNowShow() {
        return timeNowShow;
    }
    public Text getTimeSignal() {
        return timeSignal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }
    public void setTimeSignalDate(String timeSignalDate) {
        this.timeSignalDate = timeSignalDate;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
