package ru.AccessTime.GUI.Controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;
import ru.AccessTime.Accounting.AccountingHandler;
import ru.AccessTime.GUI.WorkController;
import ru.AccessTime.Serviceman.Condition;
import ru.AccessTime.Serviceman.Serviceman;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;


public class ControllerSettingWin extends Observable implements Initializable {
    public WorkController workController;
    ObservableList <Condition> conditionList = FXCollections.observableArrayList(Condition.values());

    @FXML
    private Text dateUpdateShow;

    @FXML
    private TableView tableSetting;

    @FXML
    private TableColumn <Serviceman, Integer> tableSettingPP;

    @FXML
    private TableColumn <Serviceman, String> settingFIO;

    @FXML
    private TableColumn <Serviceman, Condition> settingCondition;

    @FXML
    private Text timeNowShow;

    @FXML
    public Button bSaveSetting;

    @FXML
    private Button bNewServicemanWin;

    @FXML
    private Button bExitSettingWin;

    public void  bSaveSetting() {

    }
    public void newServicemanWin() {
        workController.showNewServiseman();
    }
    public void exitSetting() {
        workController.getStageSettingWin().close();

    }

    public void setWorkController(WorkController workController) {
        this.workController = workController;
    }

    public Button getbSaveSetting() {
        return bSaveSetting;
    }
    public Button getbNewServicemanWin() {
        return bNewServicemanWin;
    }
    public Button getbExitSettingWin() {
        return bExitSettingWin;
    }
    public Text getTimeNowShow() {
        return timeNowShow;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadingTableServiceman();                                                                                                                       // Загружаем данные в таблицу на страцие уточнения
        comboBoxTableCell();                                                                                                                            // Позволяет менять положения СОСТОЯНИЯ
        tableSetting.setItems(AccountingHandler.servicemenList);
    }

    public void loadingTableServiceman() {
        tableSetting.setEditable(true);                                                                                                                 // делает редактируемую таблицу
        tableSettingPP.setCellValueFactory(new PropertyValueFactory <Serviceman, Integer>("nomberState"));
        settingFIO.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("surname"));
        settingCondition.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Serviceman, Condition>, ObservableValue<Condition>>() {
            @Override
            public ObservableValue<Condition> call(TableColumn.CellDataFeatures<Serviceman, Condition> param) {
                Serviceman serviceman = param.getValue();
                String conditionCode = serviceman.getCondition();
                Condition condition = Condition.getByCode(conditionCode);
                return new SimpleObjectProperty <Condition>(condition);
            }
        });
    }

    public void comboBoxTableCell() {
        settingCondition.setCellFactory(ComboBoxTableCell.forTableColumn(conditionList));
        settingCondition.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Serviceman, Condition>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Serviceman, Condition> event) {
                TablePosition<Serviceman, Condition> pos = event.getTablePosition();
                Condition newCondition = event.getNewValue();
                int row = pos.getRow();
                Serviceman serviceman = event.getTableView().getItems().get(row);
                serviceman.setCondition(newCondition.getCode());
            }
        });

    }

    public void saveNewServicemanList () {
        ObservableList <Serviceman> servicemenList2 = tableSetting.getItems();


            for (Serviceman serviceman : AccountingHandler.servicemenList) {
                String formatted = String.format("%s %s (%s)", serviceman.getNomberState(), serviceman.getSurname(), serviceman.getCondition());
                System.out.println(formatted);
            }


    }


}
