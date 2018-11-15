package ru.AccessTime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.AccessTime.GUI.WorkController;
import ru.AccessTime.WorkBD.ConnectionBD;
import ru.AccessTime.WorkBD.WorkBase;

public class Main extends Application{
    public static WorkController workController;

    public static void main(String[] args) {
        workController = new WorkController();
        WorkBase workBase = new WorkBase();

        //workBase.creatNewServisman(1,"НИС", "Овсяников", "Евгений", "Евгений");
        System.out.println("Прошло");
        launch(args);

    }
    // эта надпись для проверки



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootOneWin = FXMLLoader.load(getClass().getResource("GUI/FXML/oneWin.fxml"));
        primaryStage.setTitle("Контроль прибытия сотрудников v1.0");
        primaryStage.setScene(new Scene(rootOneWin));
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        ConnectionBD.connection.close();
        System.out.println("Close");


    }
}
