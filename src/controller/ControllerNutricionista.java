package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class ControllerNutricionista implements Initializable{

    @FXML
    private Hyperlink link;

    @FXML
    private Hyperlink link2;

    @FXML
    private Hyperlink link3;

    @FXML
    void openlink3(ActionEvent event) throws IOException, URISyntaxException {
    	Desktop.getDesktop().browse(new URI("https://www.google.com/"));
    }
    
    @FXML
    void openlink2(ActionEvent event) throws IOException, URISyntaxException {
    	Desktop.getDesktop().browse(new URI("https://valenciabase.com/que-comer-antes-y-despues-de-un-partido-de-futbol-y-entrenamiento/"));
    }
    
    @FXML
    void openLink(ActionEvent event) throws IOException, URISyntaxException {
    	Desktop.getDesktop().browse(new URI("https://www.fisterra.com/ayuda-en-consulta/dietas/dieta-1.500-kcalorias-menus/"));
    }
	
	public void closeWindows() {
		
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/medicoView.fxml"));
            Parent root = loader.load();
            ControllerTipoMedico controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
           //Stage myStage = (Stage) this.btnClose.getScene().getWindow();
          // myStage.close();
            
        	}catch(IOException ex) {
        	
        		Logger.getLogger(ControllerTipoMedico.class.getName()).log(Level.SEVERE, null, ex);
        	}
		
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
