package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class VerClasificacionController implements Initializable{

	
    @FXML
    private ImageView myImageView;

    @FXML
    private Button btnChange1;

    @FXML
    private Button btnChange2;

    @FXML
    private Button btnChange3;
    
    
    Image myImage1 = new Image(getClass().getResourceAsStream("/imagenes/imagen1Division.jpg"));

    Image myImage2 = new Image(getClass().getResourceAsStream("/imagenes/imagen2Division.jpg"));
	
    Image myImage3 = new Image(getClass().getResourceAsStream("/imagenes/imagen2bDivision.jpg"));


    public void changeImage1() {
    	myImageView.setImage(myImage1);
    }
    
    public void changeImage2() {
    	myImageView.setImage(myImage2);
    }
    
    public void changeImage2b() {
    	myImageView.setImage(myImage3);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
