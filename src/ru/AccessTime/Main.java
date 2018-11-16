package ru.AccessTime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.AccessTime.GUI.Controllers.ControllerOneWin;
import ru.AccessTime.WorkBD.ConnectionBD;
import ru.AccessTime.WorkBD.WorkBase;

public class Main extends Application{


    public static void main(String[] args) {


        WorkBase workBase = new WorkBase();
        //workBase.creatNewServisman(1,"НИС", "Овсяников", "Евгений", "Евгений");
        System.out.println("Прошло");
        launch(args);

    }
    // эта надпись для проверки



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loaderOneWin = new FXMLLoader();
        loaderOneWin.setLocation(getClass().getResource("GUI/FXML/oneWin.fxml"));
        Parent rootOneWin = loaderOneWin.load();
        primaryStage.setTitle("Контроль прибытия сотрудников v1.0");
        primaryStage.setScene(new Scene(rootOneWin));
        ControllerOneWin controllerOneWin = loaderOneWin.getController();
        controllerOneWin.workController.eventOneWin();

        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        ConnectionBD.connection.close();
        System.out.println("Close");


    }
}
