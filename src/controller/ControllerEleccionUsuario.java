package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerEleccionUsuario implements Initializable{

	 @FXML
	    private Button btnMedico;

	    @FXML
	    private Button btnEntrenador;

	    @FXML
	    private Button btnJugador;

	    
	    
	    @FXML
	    void accesoEntrenador(ActionEvent event) {
            //JOptionPane.showMessageDialog(null, "BIENVENIDO ENTRENADOR!", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
            
            try {
            	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/entrenador_view.fxml"));
            	Parent root = loader.load();
                //ControllerEleccionUsuario controlador = loader.getController();
                //controlador del entrenador en controllerEleccion usuario
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.show();
                
               //Stage myStage = (Stage) this.btnClose.getScene().getWindow();
              // myStage.close();
                
            	}catch(IOException ex) {

            		Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            	}
	    }

	    @FXML
	    void accesoJugador(ActionEvent event) {
            try {//cambiar fxml
            	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/VmenuJugador.fxml"));
                Parent root2 = loader2.load();
                //ControllerEleccionUsuario controlador = loader.getController();
                //controlador del entrenador en controllerEleccion usuario
                Scene scene = new Scene(root2);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.show();
                
               //Stage myStage = (Stage) this.btnClose.getScene().getWindow();
              // myStage.close();
                
            	}catch(IOException ex) {
            	
            		Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            	}
	    }

	    @FXML
	    void accesoMedico(ActionEvent event) {
            try {//*cambiar fxml
            	FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/view/medicoView.fxml"));
                Parent root3 = loader3.load();
                //*ControllerEleccionUsuario controlador = loader.getController();
                //*controlador del entrenador en controllerEleccion usuario
                Scene scene = new Scene(root3);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.show();
                
               //Stage myStage = (Stage) this.btnClose.getScene().getWindow();
              // myStage.close();
                
            	}catch(IOException ex) {
            	
            		Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            	}
	    }


	    
	


	public void closeWindows() {
		
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InterfazLog.fxml"));
            Parent root = loader.load();
            LoginController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
           //Stage myStage = (Stage) this.btnClose.getScene().getWindow();
          // myStage.close();
            
        	}catch(IOException ex) {
        	
        		Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        	}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
