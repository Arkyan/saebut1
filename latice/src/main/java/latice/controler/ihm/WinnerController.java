package latice.controler.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import latice.model.infoplayer.Player;

public class WinnerController {
	@FXML
	private Label idLblPLayerWinner;
	
	public void setWinner(Player winner) {
		idLblPLayerWinner.setText(winner.getName());
	}

}
