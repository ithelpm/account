package com.github.ithelpm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AppController {
    @FXML
    private Button confirmBtn, showBtn, resetBtn;
    @FXML
    private TextField price;
    @FXML
    private Label date;

    @FXML
    private void confirm(ActionEvent event) {
        if(!price.getText().isEmpty()||price.getText()!=null) {
            App.data2write=price.getText();
            price.setText("");
        }
        
    }

    @FXML
    private void showPic() {
        PathTool pt = new PathTool();
        pt.executeScript(App.scriptLib, "Statics.py");
    }

    @FXML
    private void resetCSV() {
        
    }
}
