package latice.controler.ihm;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicManager {
	private static MediaPlayer instance;
	
	public static void play(String soundFile) {
		musicStop();
		Media media = new Media(MusicManager.class.getResource(soundFile).toExternalForm());
		instance = new MediaPlayer(media);
		instance.setCycleCount(MediaPlayer.INDEFINITE);
		instance.play();
		
	}
	
	public static void musicStop() {
	if ( instance != null ) {
			instance.stop();
		}
	}

}
