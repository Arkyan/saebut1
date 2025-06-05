package latice.controler.ihm;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import latice.view.ImageLoading;

public class ParametersController {

    @FXML
    private Button btnExit;

    @FXML
    private HBox hbThemes;
    
    @FXML
    private BorderPane bpParameters;

    @FXML
    private Slider idSoundSlider;
    
    @FXML
    private ImageView imagetheme1;
    
    @FXML
    private ImageView imagetheme2;
    
    @FXML
    private ImageView imagetheme3;
        
	@FXML
	void goBack() {
		Stage stage = (Stage) btnExit.getScene().getWindow();
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
	
	@FXML
    public void initialize() {
	    String imagesPath = ImageLoading.getPath();
	    bpParameters.setStyle("-fx-background-image: url('" + imagesPath + "/parameters_background.png');");
		
		Image theme1 = new Image(getClass().getResourceAsStream("/latice_lazuli/images/theme_mine.png"));
		Image theme2 = new Image(getClass().getResourceAsStream("/sanrio/images/theme_sanrio.png"));
		Image theme3 = new Image(getClass().getResourceAsStream("/cheap/images/theme_cheap.png"));
		
		imagetheme1.setImage(theme1);
		imagetheme2.setImage(theme2);
		imagetheme3.setImage(theme3);
    }
	
	@FXML
	public void changeTheme1() {
		String path1 = "/latice_lazuli/images";
	    System.out.println("Thème 1 sélectionné");
	    ImageLoading.setPath(path1);
	}
	
	@FXML
	public void changeTheme2() {
		String path2 = "/sanrio/images";
	    System.out.println("Thème 2 sélectionné");
	    ImageLoading.setPath(path2);
	}
	
	@FXML
	public void changeTheme3() {
		String path3 = "/cheap/images";
	    System.out.println("Thème 3 sélectionné");
	    ImageLoading.setPath(path3);
	}

}
