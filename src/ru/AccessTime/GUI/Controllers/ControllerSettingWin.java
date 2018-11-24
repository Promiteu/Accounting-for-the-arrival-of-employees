package ru.AccessTime.GUI.Controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.Callback;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import ru.AccessTime.Accounting.AccountingHandler;
import ru.AccessTime.GUI.Dialogs.DialogManager;
import ru.AccessTime.GUI.WorkController;
import ru.AccessTime.Serviceman.Condition;
import ru.AccessTime.Serviceman.Serviceman;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;


public class ControllerSettingWin extends Observable implements Initializable {
    public boolean saving = true;

    public WorkController workController;

    public ObservableList <Serviceman> tableServicemenList = FXCollections.observableArrayList();

    ObservableList <Condition> conditionList = FXCollections.observableArrayList(Condition.values());

    @FXML
    private Text dateUpdateShow;

    @FXML
    public CustomTextField ctfIntLastname;

    @FXML
    public Button btnFind;

    @FXML
    private TableView tableSetting;

    @FXML
    private TableColumn <Serviceman, Integer> tableSettingPP;

    @FXML
    public TableColumn <Serviceman, String> settingPosition;

    @FXML
    private TableColumn <Serviceman, String> settingSurname;

    @FXML
    public TableColumn <Serviceman, String> settingName;

    @FXML
    public TableColumn <Serviceman, String> settingPatronymic;

    @FXML
    private TableColumn <Serviceman, Condition> settingCondition;

    @FXML
    private Text timeNowShow;

    @FXML
    public Button bSaveSetting;

    @FXML
    private Button bNewServicemanWin;

    @FXML
    public Button btnDeletServiceman;

    @FXML
    private Button bExitSettingWin;

    public void newServicemanWin() {
        workController.showNewServiseman();
    }
    public void exitSetting() {
        if (!saving) {
            DialogManager.showWarningDialog("Внимание", "Сохраните уточнение изменений перед выходом!");
        } else {
            workController.getStageSettingWin().close();
            AccountingHandler.servicemenList.clear();
            workController.workBase.lodingServicemanList();
        }
    }

    public void setWorkController(WorkController workController) {
        this.workController = workController;
    }

    public Text getTimeNowShow() {
        return timeNowShow;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableServicemenList.addAll(AccountingHandler.servicemenList);
        loadingTableServiceman();                                                                                                                       // Загружаем данные в таблицу на страцие уточнения
        comboBoxTableCell();                                                                                                                            // Позволяет менять положения СОСТОЯНИЯ
        tableSetting.setItems(tableServicemenList);
        setupClearButtonField(ctfIntLastname);
        createEnterForNode();
        correctionDateOut();


    }

    public void createEnterForNode() {
        ctfIntLastname.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                findServiceman ();
            }
        });
        btnFind.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                findServiceman ();
            }
        });
        bSaveSetting.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                saveNewServicemanList ();
            }
        });
        bNewServicemanWin.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                newServicemanWin();
            }
        });
        btnDeletServiceman.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                deleteServiceman ();
            }
        });
        bExitSettingWin.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                exitSetting();
            }
        });
    }

    public void loadingTableServiceman() {
        tableSetting.setEditable(true);                                                                                                                 // делает редактируемую таблицу
        tableSettingPP.setCellValueFactory(new PropertyValueFactory <Serviceman, Integer>("nomberState"));
        settingPosition.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("position"));
        settingSurname.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("surname"));
        updateNameServiceman (settingSurname);
        settingName.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("name"));
        updateNameServiceman (settingName);
        settingPatronymic.setCellValueFactory(new PropertyValueFactory <Serviceman, String >("patronymic"));
        updateNameServiceman (settingPatronymic);
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
                saving = false;
            }
        });

    }
    public void updateNameServiceman (TableColumn tableColumn) {
        tableColumn.setCellFactory(TextFieldTableCell.<Serviceman> forTableColumn());
        tableColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                TablePosition<Serviceman, String> pos = event.getTablePosition();
                String newName = event.getNewValue().toString();
                int row = pos.getRow();
                Serviceman serviceman = (Serviceman) event.getTableView().getItems().get(row);
              switch (tableColumn.getId()){
                  case "settingSurname":
                      serviceman.setSurname(newName);
                      saving = false;
                      break;
                  case "settingName":
                      serviceman.setName(newName);
                      saving = false;
                      break;
                  case "settingPatronymic":
                      serviceman.setPatronymic(newName);
                      saving = false;
                      break;
                }
            }
        });

    }
    public void deleteServiceman () {
        Serviceman serviceman = (Serviceman) tableSetting.getSelectionModel().getSelectedItem();
        workController.workBase.deleteServisman(serviceman);
        tableServicemenList.remove(serviceman);
    }

    public void saveNewServicemanList () {
            for (Serviceman serviceman : tableServicemenList) {
                workController.workBase.updateServisman(serviceman);
                }
                correctionDateIn();
                saving = true;
    }
    public void findServiceman () {
        saveNewServicemanList ();
        tableServicemenList.clear();
        for (Serviceman serviceman : AccountingHandler.servicemenList) {
            if (serviceman.getNomberState().equals(ctfIntLastname.getText().toLowerCase()) ||
                    serviceman.getPosition().toLowerCase().contains(ctfIntLastname.getText().toLowerCase()) ||
                    serviceman.getSurname().toLowerCase().contains(ctfIntLastname.getText().toLowerCase()) ||
                    serviceman.getName().toLowerCase().contains(ctfIntLastname.getText().toLowerCase()) ||
                    serviceman.getPatronymic().toLowerCase().contains(ctfIntLastname.getText().toLowerCase())||
                    serviceman.getCondition().equals(Condition.getByCodeString(ctfIntLastname.getText()))) {
                tableServicemenList.add(serviceman);
            }
        }


    }
    private void setupClearButtonField(CustomTextField customTextField) {
        try {
            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
            m.setAccessible(true);
            m.invoke(null, customTextField, customTextField.rightProperty());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void correctionDateOut () {
        BufferedReader br = null;
        try {
            File fileCor = new File("CorrectionDate.txt");
            if (!fileCor.exists()){
                fileCor.createNewFile();
            }
            br = new BufferedReader(new FileReader("CorrectionDate.txt"));
            String correctionDate;
            while ((correctionDate = br.readLine()) != null) {
                dateUpdateShow.setText(correctionDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void correctionDateIn () {
        try {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_WEEK,1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.YYYY");
            String correctionDate = simpleDateFormat.format(calendar.getTime()).toString();
            PrintWriter pw = new PrintWriter("CorrectionDate.txt");
            pw.println(correctionDate);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
