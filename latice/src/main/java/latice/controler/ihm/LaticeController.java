package latice.controler.ihm;

import static latice.controler.Referee.MAX_TILES_IN_RACK;
import static latice.controler.Referee.NUMBER_OF_ROUND_BEFORE_VICTORY;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import latice.controler.Referee;
import latice.model.boardgame.CellLayout;
import latice.model.infoplayer.Player;
import latice.model.slate.Tile;
import latice.view.ImageLoading;

public class LaticeController {
	
	Integer addedPoints;

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
    private BorderPane bpBoard;
    
    @FXML
    private ImageView actionsJauge;
    
    String imagesPath = ImageLoading.getPath();

    @FXML
    void buyAdditionalAction(ActionEvent event) {
    	if (currentPlayer.getRack().getTiles().isEmpty()){
			displayError("You cannot buy an additional action if you don't have any tiles in your rack.");
		}
    	else if (currentPlayer.getRack().getTiles().size() <= currentPlayer.getNumberOfActions()) {
			displayError("You cannot buy an additional action if you have less tile than you have actions.");
    	}
		else if (currentPlayer.getPoints() < 2) {
			displayError("You don't have enough points to buy an additional action");
		}
		else {
			currentPlayer.buyAction();
			updateActionJauge();
			updatePoints();
		}

    }

    @FXML
    void changeAndPass(ActionEvent event) {
    	idBtnChange.setOnAction(e -> {
    		if (currentPlayer.getRack().getTiles().size() == 5) {
    			currentPlayer.getPlayerBag().getTiles().addAll(currentPlayer.getRack().getTiles());
    			currentPlayer.getRack().getTiles().clear();
    			referee.fillRackFromPlayerBag(currentPlayer);
    			try {
    				validateRound(e);
    			} catch (Exception ex) {
    				ex.printStackTrace();
    			}
    		}
    	});
    }

    @FXML
    void validateRound(ActionEvent event) throws Exception {
    	Player player1 = referee.getPlayers().get(0);
        Player player2 = referee.getPlayers().get(1);
        Player winner = null;
        
        Integer playerOneBagSize = player1.getPlayerBag().getTiles().size();
		Integer playerTwoBagSize = player2.getPlayerBag().getTiles().size();
		if (playerOneBagSize == playerTwoBagSize && idLblNbRound.getText().equals(NUMBER_OF_ROUND_BEFORE_VICTORY.toString()) ) {
			setAndDisplayDraw(event);
			return;
		};
        
        if (idLblNbRound.getText().equals(NUMBER_OF_ROUND_BEFORE_VICTORY.toString())) {
    		if (player1.getNumberOfTilesPutOnBoard() > player2.getNumberOfTilesPutOnBoard()) {
    		    winner = player1;
    		}
    		else {
    		    winner = player2;
    		}
    		
            setAndDisplayWinner(event, winner);
        } 
        
        else if (currentPlayer.getPlayerBag().getTiles().isEmpty()) {
        	setAndDisplayWinner(event, currentPlayer);
            }
        
        else {
			referee.fillRackFromPlayerBag(currentPlayer);
        	currentPlayer.initializeNumberOfActions();
            currentPlayer = referee.getNextPlayer(currentPlayer);
            idLblPlayer.setText(currentPlayer.getName());
            idLblNbPoint.setText(currentPlayer.getPoints().toString());
            if (referee.stateOfRound()) {
                round++;
                idLblNbRound.setText(round.toString());
            }
            showTilesInRack(currentPlayer);
            updateActionJauge();
        }
    }

	public void setAndDisplayWinner(ActionEvent event, Player winner) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/winner-window.fxml"));
		Parent root = loader.load();
		
		WinnerController controllerWinner = loader.getController();
		controllerWinner.setWinner(winner); 

		Stage winnerStage = new Stage();
		winnerStage.setScene(new Scene(root));        
		winnerStage.initModality(Modality.APPLICATION_MODAL);
		winnerStage.initOwner(((Node) event.getSource()).getScene().getWindow());
		winnerStage.showAndWait();
	}
	
	public void setAndDisplayDraw(ActionEvent event) throws IOException {
		Player player1 = referee.getPlayers().get(0);
        Player player2 = referee.getPlayers().get(1);
       
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/winner-window.fxml"));
		Parent root = loader.load();
		
		WinnerController controllerWinner = loader.getController();
		controllerWinner.setDraw(player1, player2);
		Stage winnerStage = new Stage();
		winnerStage.setScene(new Scene(root));
		winnerStage.initModality(Modality.APPLICATION_MODAL);
		winnerStage.initOwner(((Node) event.getSource()).getScene().getWindow());
		winnerStage.showAndWait();
	}

    private Image carriedImage = null;
    private String carriedId = null;
    private ImageView sourceRackTile = null;
    private String imagePath = null;
    private Referee referee = new Referee();
    private Player currentPlayer;
    private Integer round = 1;

    
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
    	bpBoard.setStyle("-fx-background-image: url('" + imagesPath + "/board_background.png');");
    	loadBoardImage();
    	List<ImageView> rackImageViews = new ArrayList<>();
		for (Node node : HBoxRack.getChildren()) {
			if (node instanceof ImageView) {
				rackImageViews.add((ImageView) node);
			}
		}

    	Integer round = 1;
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
		Integer randomIndex = (int) (Math.random() * referee.getPlayers().size());
        currentPlayer = referee.getPlayers().get(randomIndex);
        updatedInformations(round);
        updateActionJauge();

        for (ImageView rackTile : rackImageViews ) {
            manageSourceDragAndDrop(rackTile);
            manageSourceClick(rackTile);
        }
		for (Node boardcell : idGp.getChildren()) {
			if (boardcell instanceof ImageView) {
				manageTargetDragAndDrop(boardcell);
				manageTargetClick(boardcell);
			}
		}
	}

    private void updatedInformations(Integer round) {
        idLblPlayer.setText(currentPlayer.getName());
        idLblNbRound.setText(round.toString());
        showTilesInRack(currentPlayer);
        updatePoints();
    }
    
	private void updatePoints() {
		idLblNbPoint.setText(currentPlayer.getPoints().toString());
	}
	
	private void updateActionJauge() {
		actionsJauge.setImage(new Image(Objects.requireNonNull(getClass().getResource(imagesPath + "/jauge_" + currentPlayer.getNumberOfActions() + ".png")).toExternalForm()));
	}

    public void showTilesInRack(Player player) {
        ImageLoading loader = new ImageLoading();

        List<Tile> tiles = player.getRack().getTiles();
        List<ImageView> rackImageViews = new ArrayList<>();
		for (Node node : HBoxRack.getChildren()) {
			if (node instanceof ImageView) {
				rackImageViews.add((ImageView) node);
			}
		}

        for (Integer indexOfCase = 0; indexOfCase < MAX_TILES_IN_RACK; indexOfCase++) {
            ImageView imageView = rackImageViews.get(indexOfCase);
            if (indexOfCase < tiles.size()) {
                Tile tile = tiles.get(indexOfCase);
                String path = loader.getImagePath(tile.getColor(), tile.getShape());

                if (path != null) {
                    imageView.setImage(new Image(getClass().getResource(path).toExternalForm()));
                } else {
                    imageView.setImage(null); 
                }
            } else {
                imageView.setImage(null); 
            }
        }
    }

    public void manageSourceDragAndDrop(ImageView rackTile) {
        rackTile.setOnDragDetected(event -> {
            if (rackTile.getImage() != null) {
            	if (rackTile.getImage() != null && rackTile.getImage().getUrl().endsWith(imagesPath + "/interrogation.png")) {
                	event.consume();  
                    return;
                }
            	
                Dragboard dragboard = rackTile.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(rackTile.getImage());
                content.putString(rackTile.getId());
                dragboard.setContent(content);
                event.consume();
            }

        });

        rackTile.setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                rackTile.setImage(new Image(Objects.requireNonNull(getClass().getResource(imagesPath + "/interrogation.png")).toExternalForm()));
            }
            event.consume();
        });
    }

    public void manageTargetDragAndDrop(Node boardCell) {
        boardCell.setOnDragOver(event -> {
            if (event.getGestureSource() != boardCell && event.getDragboard().hasImage() ) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        boardCell.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();

            ImageView target = (ImageView) event.getGestureTarget();
            ImageView source = (ImageView) event.getGestureSource();
            Integer row = GridPane.getRowIndex(target);
            Integer col = GridPane.getColumnIndex(target);
            String url = source.getImage().getUrl();
            File file = null;
            try {
                file = Paths.get(new URI(url)).toFile();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            String sourceTileFilePath = "/" + file.getName();
            Tile sourceTile = new ImageLoading().getTileFromImage(sourceTileFilePath);

            if (db.hasImage() && referee.isPlacementValid(sourceTile, row, col, referee.getBoard()) && currentPlayer.playerCanPlay()) {
            	referee.placeTileOnBoard(sourceTile, row, col, currentPlayer);
                currentPlayer.setNumberOfTilesPutOnBoard(currentPlayer.getNumberOfTilesPutOnBoard() + 1);

                Image image = db.getImage();
                ((ImageView) boardCell).setImage(image);
                
				if (referee.isLatice(sourceTile, row, col)) {
					printSparklesWhenLatice();
				}
				updatePoints();
				
				event.setDropCompleted(true);
                event.consume();
                currentPlayer.useAction();
                updateActionJauge();
            } else {
                event.setDropCompleted(false);
            }

        });
    }


    public void manageSourceClick(ImageView rackTile) {
        rackTile.setOnMouseClicked(event -> {
            if (carriedImage == null && rackTile.getImage() != null) {
                carriedImage = rackTile.getImage();
                carriedId = rackTile.getId();
                sourceRackTile = rackTile;   
                imagePath = carriedImage.getUrl();
            }
            
            if (imagePath != null && imagePath.endsWith("/interrogation.png")) {
				carriedImage = null;
				carriedId = null;
			}
        });
    }

    public void manageTargetClick(Node boardCell) {
        boardCell.setOnMouseClicked(event -> {
            if (carriedImage != null && carriedId != null && boardCell instanceof ImageView) {
                ImageView targetCell = (ImageView) boardCell;

                Integer row = GridPane.getRowIndex(targetCell);
                Integer col = GridPane.getColumnIndex(targetCell);
                File file = null;
                try {
                    file = Paths.get(new URI(imagePath)).toFile();
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                String sourceTileFilePath = "/" + file.getName();
                Tile sourceTile = new ImageLoading().getTileFromImage(sourceTileFilePath);
                
                if (targetCell.getImage() != null && referee.isPlacementValid(sourceTile, row, col, referee.getBoard()) && currentPlayer.playerCanPlay()) {
                    referee.placeTileOnBoard(sourceTile, row, col, currentPlayer);
                    currentPlayer.setNumberOfTilesPutOnBoard(currentPlayer.getNumberOfTilesPutOnBoard() + 1);
                	Image Emptyimage = new Image(Objects.requireNonNull(getClass().getResource(imagesPath + "/interrogation.png")).toExternalForm());
                	targetCell.setImage(carriedImage);
                	
                	if (referee.isLatice(sourceTile, row, col)) {
    					printSparklesWhenLatice();
    				}
                	
                	updatePoints();
                	sourceRackTile.setImage(Emptyimage);
                	currentPlayer.useAction();
                	updateActionJauge();
                }
                carriedImage = null;
                carriedId = null;
                sourceRackTile = null;
            }
            event.consume();
        });
    }
    
    private void displayError(String errorType) {
    	idBtnBuy.setDisable(true);
    	Alert alert = new Alert(Alert.AlertType.ERROR);
    	alert.setTitle("Error while buying an action");
    	alert.setHeaderText("An error occurred while trying to buy an action");
    	alert.setContentText(errorType);
    	
    	alert.getButtonTypes().setAll(new ButtonType("Continue"));
    	Optional<ButtonType> result = alert.showAndWait();
    	idBtnBuy.setDisable(false);
    }
    
    private void loadBoardImage() {
        for (Node node : idGp.getChildren()) {
            if (node instanceof ImageView imageView) {
                Integer row = GridPane.getRowIndex(imageView);
                Integer col = GridPane.getColumnIndex(imageView);

                int r = row != null ? row : 0;
                int c = col != null ? col : 0;

                if (r == 4 && c == 4) {
                    imageView.setImage(new Image(Objects.requireNonNull(getClass().getResource(imagesPath + "/bg_moon.png")).toExternalForm()));
                } else if (CellLayout.isSunCell(r, c)) {
                    imageView.setImage(new Image(Objects.requireNonNull(getClass().getResource(imagesPath + "/bg_sun.png")).toExternalForm()));
                } else {
                    imageView.setImage(new Image(Objects.requireNonNull(getClass().getResource(imagesPath + "/bg_sea.png")).toExternalForm()));
                }
            }
        }
    }

	public void printSparklesWhenLatice() {
		// Load sparkle image
		Image sparkleImage = new Image(getClass().getResource(imagesPath + "/sparkles.png").toExternalForm());

		// Create a Timeline to generate sparkles periodically
		Timeline sparkleTimeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
			// Generate multiple sparkles in each cycle
			for (int i = 0; i < 5; i++) { // Adjust the number of sparkles per cycle
				// Create a new ImageView for the sparkle
				ImageView sparkle = new ImageView(sparkleImage);
				sparkle.setFitWidth(20); // Set sparkle size
				sparkle.setFitHeight(20);

				// Ensure bpBoard dimensions are valid
				double boardWidth = bpBoard.getWidth();
				double boardHeight = bpBoard.getHeight();
				if (boardWidth <= 0 || boardHeight <= 0) {
					return; // Exit if dimensions are invalid
				}

				// Randomly position the sparkle within the scene
				double randomX = Math.random() * boardWidth;
				double randomY = Math.random() * boardHeight;
				sparkle.setLayoutX(randomX);
				sparkle.setLayoutY(randomY);

				// Add sparkle to the scene
				bpBoard.getChildren().add(sparkle);

				// Create a FadeTransition to make the sparkle fade out
				FadeTransition fade = new FadeTransition(Duration.seconds(2), sparkle);
				fade.setFromValue(1.0);
				fade.setToValue(0.0);
				fade.setOnFinished(e -> bpBoard.getChildren().remove(sparkle)); // Remove sparkle after fading
				fade.play();
			}
		}));

		// Set the timeline to run indefinitely
		sparkleTimeline.setCycleCount(10); // Increase the number of cycles
		sparkleTimeline.play();
	}
    
    
    
}
