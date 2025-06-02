package latice.controler.ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RulesController {

    @FXML
    private Button idButtonBackWindowRules;

    @FXML
    void backMainMenu(ActionEvent event) {
    	Stage stage = (Stage) idButtonBackWindowRules.getScene().getWindow();
    	stage.close();
    }

}
