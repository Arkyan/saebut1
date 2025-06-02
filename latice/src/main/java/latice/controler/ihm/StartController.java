package latice.controler.ihm;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartController {

    @FXML
    private Button idLeaveButton;

    @FXML
    private Button idParametersButton;

    @FXML
    private Button idPlayedButton;

    @FXML
    private Button idRulesButton;

    @FXML
    void launchGame() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/board-window.fxml"));
    	Parent root = loader.load();
    	
    	Stage board = new Stage();
    	board.setTitle("Latice Lazuli");
    	board.setScene(new Scene(root));
    	board.initModality(Modality.APPLICATION_MODAL);
    	board.setResizable(false);
    	board.show();
    	
    	Stage stage = (Stage) idPlayedButton.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void launchParameters(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/parameters.fxml"));
		Parent root = loader.load();

		Stage parameters = new Stage();
		parameters.setTitle("Parameters");
		parameters.setScene(new Scene(root));
		parameters.initModality(Modality.APPLICATION_MODAL);
		parameters.initOwner(((Node) event.getSource()).getScene().getWindow());
		parameters.setResizable(false);
		parameters.show();
		
    }

	@FXML
	void launchRules(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/rules-window.fxml"));
		Parent root = loader.load();

		Stage rules = new Stage();
		rules.setTitle("Rules");
		rules.setScene(new Scene(root));
		rules.initModality(Modality.APPLICATION_MODAL);
		rules.initOwner(((Node) event.getSource()).getScene().getWindow());
		rules.setResizable(false);
		rules.show();
	}

    @FXML
    void quitGame(ActionEvent event) {
    	System.exit(0);
    }

}
