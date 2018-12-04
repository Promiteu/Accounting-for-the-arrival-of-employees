package ru.AccessTime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.AccessTime.GUI.Controllers.ControllerOneWin;
import ru.AccessTime.WorkBD.ConnectionBD;

public class Main extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loaderOneWin = new FXMLLoader();
        loaderOneWin.setLocation(getClass().getResource("GUI/FXML/oneWin.fxml"));
        Parent rootOneWin = loaderOneWin.load();
        primaryStage.setTitle("Контроль прибытия сотрудников v1.0");
        primaryStage.setScene(new Scene(rootOneWin));
        primaryStage.setResizable(false);
        ControllerOneWin controllerOneWin = loaderOneWin.getController();
        primaryStage.setOnCloseRequest(event -> controllerOneWin.workController.getShowTimeNow().stopShowTime());
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();

        ConnectionBD.disconnect();



    }
}
