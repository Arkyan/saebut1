package latice.controller.ihm;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
		Stage stage = (Stage) idBtnExit.getScene().getWindow();
		stage.close();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/start-window.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Latice Lazuli");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
