package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Usuarios.Entrenador;
import Usuarios.Jugador;
import Usuarios.Medico;
import Usuarios.Usuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{


    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnclean;
    
    @FXML
    private CheckBox check;
    
    @FXML
    private TextField txtUsername,  txtPassword;

    @FXML
    private PasswordField txtPasswordF;

    @FXML
    private ComboBox<Usuarios> cbBox;

    
    
    @FXML
    void actionEventClean(ActionEvent event) {
    	cleanFields();
    }
    
    public void cleanFields(){
    	txtUsername.setText("");
    	txtPassword.setText("");
    }


    @FXML
    void actionEvent2(ActionEvent event) {

    	Object evt = event.getSource();

    	if(btnSignUp.equals(evt)) {
    	
    		if(!txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
    			
    			//Enviamos la data del jsonarray al json file tranformandolo a un string

    			JSONObject obj = new JSONObject();
    		    JSONArray jrr = new JSONArray();
    		    JSONParser jp = new JSONParser();
    		    
    		    try {
    		    	FileReader file = new FileReader("Usuarios.json");
    		    	jrr=(JSONArray) jp.parse(file);
    		    }catch(Exception ex) {
    				JOptionPane.showConfirmDialog(null, "Error en el json");
    		    }
    		    
    			obj.put("Username", txtUsername.getText());
    			obj.put("Password", txtPassword.getText());
    			jrr.add(obj);
    			try {
    				FileWriter file = new FileWriter("Usuarios.json");
    				file.write(jrr.toJSONString());
    				file.close();
    			}catch(Exception ex) {
    				JOptionPane.showConfirmDialog(null, "Error en el json");
    			}
    			
    			JOptionPane.showMessageDialog(null, "Usuario guardado");
    		}
    	}
    }

    @FXML
    void actionEvent1(ActionEvent event) {
    	JSONArray jrr = new JSONArray();
    	Object ob = null;
    	JSONParser jp = new JSONParser();
    	//busqueda de archivo
    	try {
    		FileReader file = new FileReader("Usuarios.json");
    		ob = jp.parse(file);
    		jrr = (JSONArray) ob;
    		file.close();
    	}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al leer el json");

    	}
    	
    	JSONObject obj = new JSONObject();
    	int size = jrr.size();
		obj.put("Username", txtUsername.getText());
		obj.put("Password", txtPassword.getText());
		for(int i=0;i<size;i++) {
			if(obj.equals(jrr.get(i))) {
	            JOptionPane.showMessageDialog(null, "BIENVENIDO", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
	            
	            try {
	            	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/eleccionUsuario.fxml"));
	                Parent root = loader.load();
	                ControllerEleccionUsuario controlador = loader.getController();
	                
	                Scene scene = new Scene(root);
	                Stage stage = new Stage();
	                
	                stage.setScene(scene);
	                stage.show();
	                
	               //Stage myStage = (Stage) this.btnClose.getScene().getWindow();
	              // myStage.close();
	                
	            	}catch(IOException ex) {
	            	
	            		Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
	            	}
	            break;
	                    	
	            
	    	}else if(i==size-1) {
	            JOptionPane.showMessageDialog(null, "Comprueba si has insertado la informacion bien", "ERROR", JOptionPane.ERROR_MESSAGE);
	            cleanFields();
	    	}
		}

    }

    @FXML
    void actionEvent3(ActionEvent event) {
    	JSONArray jrr = new JSONArray();
    	Object ob = null;
    	JSONParser jp = new JSONParser();
    	//busqueda de archivo
    	try {
    		FileReader file = new FileReader("Usuarios.json");
    		ob = jp.parse(file);
    		jrr = (JSONArray) ob;
    		file.close();
    	}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al leer el json");

    	}
    	
    	JSONObject obj = new JSONObject();
    	int size = jrr.size();
		obj.put("Username", txtUsername.getText());
		obj.put("Password", txtPassword.getText());
		for(int i=0;i<size;i++) {
			if(obj.equals(jrr.get(i))) {
				try {
    				FileWriter file = new FileWriter("Usuarios.json");
    				jrr.remove(i);
    				file.write(jrr.toJSONString());
    				file.close();
    			}catch(Exception ex) {
    				JOptionPane.showConfirmDialog(null, "Error en el json");
    			}	            JOptionPane.showMessageDialog(null, "Eliminado", "Hasta pronto!", JOptionPane.INFORMATION_MESSAGE);
	            break;
	    	}else if(i==size-1) {
	            JOptionPane.showMessageDialog(null, "Comprueba si has insertado la informacion bien", "ERROR", JOptionPane.ERROR_MESSAGE);
	            cleanFields();
	    	}
		}
    }

    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cbBox.getItems().addAll(createRolUsers());	//me devuleve el usuario
        maskPassword(txtPasswordF, txtPassword, check);

	}
	
	private ArrayList<Usuarios> createRolUsers(){
		
		ArrayList<Usuarios> usuario = new ArrayList<>();
	
		usuario.add(new Medico("Medico"));
		usuario.add(new Jugador("Jugador"));
		usuario.add(new Entrenador("Entrenador"));

		return usuario;
	}
	
    public void maskPassword(PasswordField pass, TextField text, CheckBox check){   //concetar propiedades para el checkbox
        
        text.setVisible(false);			//ocultamos texto
        text.setManaged(false);			//oculta y borra
            
        text.managedProperty().bind(check.selectedProperty());			//se oculta el textfield cuando demos al check
        text.visibleProperty().bind(check.selectedProperty());			
        text.textProperty().bindBidirectional(pass.textProperty());		//para compartir textos entre password y textfield
    
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

}
