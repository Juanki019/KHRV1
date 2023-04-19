package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerDetallesPartido3 implements Initializable{

    @FXML
    private Button btnPlay3, btnReset3;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button btnPause3;

 
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer; //controller del playing del video
    

    @FXML
    void pauseMedia3(ActionEvent event) {
    	mediaPlayer.pause();
    }

    @FXML
    void playMedia3(ActionEvent event) {
    	mediaPlayer.play();

    }

    @FXML
    void resetMedia3(ActionEvent event) {
    	mediaPlayer.seek(Duration.seconds(0.0));;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	media = new Media(new File("src/media/resumen3.mp4").toURI().toString());
    	mediaPlayer = new MediaPlayer(media);
    	mediaView.setMediaPlayer(mediaPlayer);
	}
	
	public void closeWindows() {
		
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/entrenador_view.fxml"));
            Parent root = loader.load();
            MainViewController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
           //Stage myStage = (Stage) this.btnClose.getScene().getWindow();
          // myStage.close();
            
        	}catch(IOException ex) {
        	
        		Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        	}
		
	}
	
}
