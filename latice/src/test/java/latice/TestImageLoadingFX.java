package latice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import latice.model.slate.Color;
import latice.model.slate.Shape;
import latice.view.ImageLoading;

public class TestImageLoadingFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImageLoading loader = new ImageLoading();
        
        String imagePath = loader.getImagePath(Color.Teal, Shape.DOLPHIN);

        if (imagePath == null) {
            System.out.println("Chemin d'image introuvable.");
            return;
        }

        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200); 
            imageView.setPreserveRatio(true);

            StackPane root = new StackPane(imageView);
            Scene scene = new Scene(root, 300, 300);

            primaryStage.setTitle("Test Image Loading");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Errot : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
