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
        PathTool pt = new PathTool();
        App.storagePath = chooser.showDialog(null).toPath().toString();
        //append data =>
        pt.executeScript(App.scriptLib, "csvWriter.py "+);
        //.
        //.
        //=================================================================
        Stage stage =(Stage)button.getScene().getWindow();
        stage.setScene(App.mainScene(App.fxmlPath.toString()));
    }
}