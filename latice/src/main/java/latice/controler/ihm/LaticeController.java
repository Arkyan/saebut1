package latice.controler.ihm;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import latice.controler.Referee;

public class LaticeController {

    @FXML
    private Button idBtnBuy;

    @FXML
    private Button idBtnChange;

    @FXML
    private Button idBtnValider;

    @FXML
    private HBox idGbBot;

    @FXML
    private GridPane idGp;

    @FXML
    private HBox idHbTop;

    @FXML
    private Label idLbPoint;
    
    @FXML
    private HBox HBoxRack;

    @FXML
    void buyAdditionalAction(ActionEvent event) {

    }

    @FXML
    void changeAndPass(ActionEvent event) {

    }

    @FXML
    void validerTour(ActionEvent event) {

    }

    
    String getNamePlayer(String nbPlayer) {
        String namePlayer = "";
        Label lblError = new Label("Input a pseudo");
        lblError.setVisible(false);
        lblError.setStyle("-fx-text-fill: red; -fx-font-size: 12px; -fx-padding: 5px;");
        TextInputDialog playerNameInputDialog = new TextInputDialog();

        playerNameInputDialog.setTitle("Identification");
        playerNameInputDialog.setHeaderText("Input pseudo for player " + nbPlayer);
        playerNameInputDialog.setContentText("Please enter your pseudo here: ");
        
        DialogPane dialogPane = playerNameInputDialog.getDialogPane();
        TextField textField = (TextField) dialogPane.lookup(".text-field");
        VBox content = new VBox(5);
        content.getChildren().addAll(textField, lblError);
        
        dialogPane.setContent(content);

        Optional<String> pseudo = playerNameInputDialog.showAndWait();
        if (pseudo.isPresent()) {
            namePlayer = pseudo.get();
            return namePlayer;
        }
        else {
			lblError.setVisible(true);
        }
		return namePlayer;
        
    }
    
    @FXML
	void initialize() {
		Referee referee = new Referee();
		String namePlayer1 = "" ;
		String namePlayer2 = "";
		
		while (namePlayer1.isEmpty()) {
			namePlayer1 = getNamePlayer("one");
		}
		while (namePlayer2.isEmpty() || namePlayer1.equals(namePlayer2)) {
			namePlayer2 = getNamePlayer("two");
		}
		
		
	}
    
}
