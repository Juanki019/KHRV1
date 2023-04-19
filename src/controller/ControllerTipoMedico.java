package controller;

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
import javafx.stage.Stage;

public class ControllerTipoMedico implements Initializable{

    @FXML
    private Button btnNutricionista;

    @FXML
    private Button btnFisio;

    @FXML
    void navegarFisio(ActionEvent event) {

        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fisioView.fxml"));
            Parent root = loader.load();
            ControllerFisio controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador.closeWindows());

            //cierro la ventana donde estoy
            Stage myStage = (Stage) this.btnFisio.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        	
        		Logger.getLogger(ControllerTipoMedico.class.getName()).log(Level.SEVERE, null, ex);
        	}
    	
    }

    @FXML
    void navegarNutricionista(ActionEvent event) {

        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/nutricionistaView.fxml"));
            Parent root = loader.load();
            ControllerNutricionista controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador.closeWindows());

            //cierro la ventana donde estoy
            Stage myStage = (Stage) this.btnNutricionista.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        	
        		Logger.getLogger(ControllerTipoMedico.class.getName()).log(Level.SEVERE, null, ex);
        	}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
