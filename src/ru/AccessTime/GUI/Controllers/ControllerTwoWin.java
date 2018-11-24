package ru.AccessTime.GUI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import ru.AccessTime.Accounting.AccountingHandler;
import ru.AccessTime.GUI.Dialogs.DialogManager;
import ru.AccessTime.GUI.WorkController;
import ru.AccessTime.Serviceman.Serviceman;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerTwoWin  implements Initializable{
    public WorkController workController;
    private ObservableList<Serviceman> servicemenListFull = FXCollections.observableArrayList();
    private ObservableList<Serviceman> servicemenListAccounting = FXCollections.observableArrayList();
    private String signal;
    private String timeSignalDate;


    private double percent;
    private String date;

    @FXML
    private Text timeSignal;

    @FXML
    private TableView tableTwo;

    @FXML
    private TableColumn numberPPTW;

    @FXML
    public TableColumn positionTW;

    @FXML
    private TableColumn surnameTW;

    @FXML
    public TableColumn nameTW;

    @FXML
    public TableColumn patronymicTW;

    @FXML
    private TableColumn timeArrival;

    @FXML
    private Text timeNowShow;

    @FXML
    private Text percents;

    @FXML
    private TextField tfNumberState;

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

    public Text getTimeNowShow() {
        return timeNowShow;
    }
    public Text getTimeSignal() {
        return timeSignal;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setTimeSignalDate (String timeSignalDate) {
        this.timeSignalDate = timeSignalDate;
    }

    public void lodingTableServicemanTW () {
        for (Serviceman serviceman : AccountingHandler.servicemenList) {
            if (!serviceman.getCondition().equals("On")) {
                serviceman.setTimeAcc(timeSignalDate);
                servicemenListAccounting.add(serviceman);
                servicemenListFull.remove(serviceman);
                workController.workBase.lodingTableNewAccounting(workController.workBase.accountingHandler.getNomberAccouting(), serviceman);

            }
            }
        numberPPTW.setCellValueFactory(new PropertyValueFactory<Serviceman, Integer>("nomberState"));
        positionTW.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("position"));
        surnameTW.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("surname"));
        nameTW.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("name"));
        patronymicTW.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("patronymic"));
        timeArrival.setCellValueFactory(new PropertyValueFactory<Serviceman, String >("timeAcc"));
        tableTwo.setItems(servicemenListAccounting);
        percentsShow ();
        workController.workBase.updateAction(workController.workBase.accountingHandler.getNomberAccouting(), percent);



    }

    public void addTableNewAccounting () {

        try {
            Integer numberStat = Integer.valueOf(tfNumberState.getText());
            Serviceman serviceman = null;
            for (Serviceman servicemani : AccountingHandler.servicemenList) {
                if (servicemani.getNomberState().equals(numberStat)) {
                    for (Serviceman servicemanj : servicemenListFull) {
                        if (servicemani.equals(servicemanj)) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                            String string = simpleDateFormat.format(new Date()).toString();
                            servicemani.setTimeAcc(string);
                            serviceman = servicemani;
                            servicemenListAccounting.add(servicemani);
                        }
                    }
                }
            }
            if (serviceman != null) {
                servicemenListFull.remove(serviceman);
                percentsShow ();
                workController.workBase.lodingTableNewAccounting(workController.workBase.accountingHandler.getNomberAccouting(), serviceman);
                workController.workBase.updateAction(workController.workBase.accountingHandler.getNomberAccouting(), percent);
            } else DialogManager.showInfoDialog("Предупреждение", "Военнослужащего с таким номером нет в базе!");

        } catch (Exception e) {
            DialogManager.showInfoDialog("Предупреждение", "Военнослужащего с таким номером нет в базе!");
        }




    }

    public void percentsShow () {
         percent = (servicemenListAccounting.size() * 100 / AccountingHandler.servicemenList.size());

         percents.setText(String.valueOf(percent) + "%");

    }

    public void printExcel () {
        workController.getWorkExcel().creatNewExcel(servicemenListAccounting, timeSignalDate, date, (String.valueOf(percent) + "%"));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        servicemenListFull.addAll(AccountingHandler.servicemenList);

    }
}
