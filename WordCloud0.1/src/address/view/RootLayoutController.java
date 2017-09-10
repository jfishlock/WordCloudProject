package address.view;

import address.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class RootLayoutController {

    private Main main;

    public void setMain(Main main){
        this.main= main;
    }

    @FXML
    private void handleAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Word Cloud App");
        alert.setHeaderText("About");
        alert.setContentText("Author: Jake Fishlock c1664204");

        alert.showAndWait();
    }

    @FXML
    private void handleExit(){
        System.exit(0);
    }
}
