package com.github.ithelpm;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;

public class ChooserController {
    @FXML
    private Button button;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd");
    private DirectoryChooser chooser = new DirectoryChooser();

    @FXML
    private void buttonEvent(ActionEvent event) {
        Writer wt = new Writer();
        App.storagePath = chooser.showDialog(null).toPath().toString();
        wt.appendDataNTitle(App.dataPath.toString(), App.dataName, "Path2Data", App.storagePath+"\\"+App.storage);
        Stage stage =(Stage)button.getScene().getWindow();
        stage.setScene(App.mainScene(App.fxmlPath.toString()));
    }
}