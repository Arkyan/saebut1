package latice.controler.ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import latice.view.ImageLoading;

public class RulesController {

    @FXML
    private Button idButtonBackWindowRules;
    
    @FXML
    private Pane prules;
    
    @FXML
    public void initialize() {
        String imagesPath = ImageLoading.getPath();
		prules.setStyle("-fx-background-image: url('" + imagesPath + "/rules_background.png');");
	}

    @FXML
    void backMainMenu(ActionEvent event) {
    	Stage stage = (Stage) idButtonBackWindowRules.getScene().getWindow();
    	stage.close();
    }

}
