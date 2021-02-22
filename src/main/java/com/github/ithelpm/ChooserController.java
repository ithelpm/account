package com.github.ithelpm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ChooserController {
    @FXML
    private Button button;

    @FXML
    static void buttonEvent(ActionEvent event) {
        PathTool pt = new PathTool();
        Writer wt = new Writer();
        App.dataPath = pt.executeScript(App.scriptLib, "readPath.py");
        wt.appendData(App.storePath.toString(), App.dataName, "Path2Data", App.dataPath);
    }
}