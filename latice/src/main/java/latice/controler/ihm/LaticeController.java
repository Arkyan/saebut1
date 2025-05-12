package latice.controler.ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

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
    void buyAdditionalAction(ActionEvent event) {

    }

    @FXML
    void changeAndPass(ActionEvent event) {

    }

    @FXML
    void validerTour(ActionEvent event) {

    }

    @FXML
    String getNamePlayer(Integer nbPlayer) {
        String namePlayer;
        Label lblError;
        TextInputDialog playerNameInputDialog = new TextInputDialog("Pseudo");

        playerNameInputDialog.setTitle("Input pseudo for player " + nbPlayer);
        playerNameInputDialog.setHeaderText("Identification");
        playerNameInputDialog.setContentText("Please enter your pseudo here: ");

        Optional<String> pseudo = playerNameInputDialog.showAndWait();
        if (pseudo.isPresent()) {
            namePlayer = pseudo.get();
            return namePlayer;
        }
        else {

        }

        return "";
    }
}
