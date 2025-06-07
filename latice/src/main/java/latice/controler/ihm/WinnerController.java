package latice.controler.ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import latice.model.infoplayer.Player;
import latice.view.ImageLoading;

public class WinnerController {
	@FXML
	private Label idLblPLayerWinner;
	
	@FXML
	private Label idLblWinner;
	
	@FXML
	private Label idLblPlayerNames;
	
	@FXML
	private VBox vbwinner;
	
	@FXML
    private Button idBtnExit;
	
	@FXML
	public void initialize() {
		String imagesPath = ImageLoading.getPath();
		vbwinner.setStyle("-fx-background-image: url('" + imagesPath + "/winner_background.png');");
	}
	
	public void setWinner(Player winner) {
		idLblWinner.setText("The winner is :");
		idLblPlayerNames.setText(winner.getName());
		idLblPLayerWinner.setVisible(false);
	}
	
	public void setDraw(Player player1, Player player2) {
		idLblWinner.setText("It's a draw !");
		idLblPlayerNames.setText(player1.getName() + " and " + player2.getName());
		idLblPLayerWinner.setText("have the same number of tiles !");
	}
	
	@FXML
    void returnToStart(ActionEvent event) {

    }

}
