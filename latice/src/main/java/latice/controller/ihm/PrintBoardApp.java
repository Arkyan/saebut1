package latice.controller.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrintBoardApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/start-window.fxml"));

		Scene scene = new Scene(loader.load());
		
		MusicManager.play("/latice_lazuli/music/latice_lazuli.mp3");
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Latice Lazuli");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
