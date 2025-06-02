package latice.controler.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ParametersController {

    @FXML
    private Button btnExit;

    @FXML
    private HBox hbThemes;

    @FXML
    private Slider idSoundSlider;
    
	@FXML
	void goBack() {
		Stage stage = (Stage) btnExit.getScene().getWindow();
		stage.close();
	}

    

}
