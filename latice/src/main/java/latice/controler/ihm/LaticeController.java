package latice.controler.ihm;

import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import latice.controler.Referee;
import latice.model.infoplayer.Player;
import latice.model.slate.Tile;
import latice.view.ImageLoading;

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
    private Label idLblNbPoint;
    
    @FXML
    private Label idLblRound;
    
    @FXML
    private Label idLblNbRound;
    
    @FXML
    private HBox HBoxRack;
    
    @FXML
    private Label idLblPlayer;
    
    @FXML
    private ImageView rackImage1;

    @FXML
    private ImageView rackImage2;

    @FXML
    private ImageView rackImage3;

    @FXML
    private ImageView rackImage4;

    @FXML
    private ImageView rackImage5;

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
        List<ImageView> rackImageViews = List.of(
                rackImage1, rackImage2, rackImage3,
                rackImage4, rackImage5
        );

    	Integer round = 1;
		Referee referee = new Referee();
		String namePlayer1 = "" ;
		String namePlayer2 = "";
		
		while (namePlayer1.isEmpty()) {
			namePlayer1 = getNamePlayer("one");
		}
		while (namePlayer2.isEmpty() || namePlayer1.equals(namePlayer2)) {
			namePlayer2 = getNamePlayer("two");
		}
		
		Player player1 = new Player(namePlayer1);
		Player player2 = new Player(namePlayer2);
		referee.addPlayer(player1);
		referee.addPlayer(player2);
		
		referee.shuffleCollection();
		referee.distributeTilesToPlayers(referee.getPlayers());
		referee.fillAllRacks();
		//choose random player
		int randomIndex = (int) (Math.random() * referee.getPlayers().size());
		Player currentPlayer = referee.getPlayers().get(randomIndex);
		idLblPlayer.setText(currentPlayer.getName());
		idLblNbPoint.setText(currentPlayer.getPoints().toString());
		idLblNbRound.setText(round.toString());
		showTilesInRack(currentPlayer);

        for (ImageView rackTile : rackImageViews ) {
            manageSourceDragAndDrop(rackTile);
        }
		for (Node boardcell : idGp.getChildren()) {
			if (boardcell instanceof ImageView) {
				boardcell.setOnDragOver(event -> {
					if (event.getGestureSource() != boardcell && event.getDragboard().hasImage()) {
						event.acceptTransferModes(TransferMode.MOVE);
					}
					event.consume();
				});

				boardcell.setOnDragDropped(event -> {
					Dragboard db = event.getDragboard();
					if (db.hasImage()) {
						Image image = db.getImage();
						((ImageView) boardcell).setImage(image);
						event.setDropCompleted(true);
						event.consume();
					} else {
						event.setDropCompleted(false);
					}
				});
			}
		}
        
	}
    
    public void showTilesInRack(Player player) {
        ImageLoading loader = new ImageLoading();

        List<Tile> tiles = player.getRack().getTiles();
        List<ImageView> rackImageViews = List.of(
                rackImage1, rackImage2, rackImage3,
                rackImage4, rackImage5
        );

        for (int i = 0; i < rackImageViews.size(); i++) {
            ImageView imageView = rackImageViews.get(i);

            if (i < tiles.size()) {
                Tile tile = tiles.get(i);
                String path = loader.getImagePath(tile.getColor(), tile.getShape());

                if (path != null) {
                    imageView.setImage(new Image(getClass().getResource(path).toExternalForm()));
                } else {
                    imageView.setImage(null); // Si pas d'image trouvée
                }
            } else {
                imageView.setImage(null); // Cache les emplacements vides
            }
        }
    }

    public void manageSourceDragAndDrop(ImageView rackTile) {
        rackTile.setOnDragDetected(event -> {
            if (rackTile.getImage() != null) {
                Dragboard dragboard = rackTile.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(rackTile.getImage());
                dragboard.setContent(content);
                event.consume();
            }
        });

        rackTile.setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                rackTile.setImage(null);
            }
            event.consume();
        });
    }

}
