package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import usuario_jugador.Jugador;

public class CPerfilJugador implements Initializable{

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbApellido;

    @FXML
    private Label lbDni;

    @FXML
    private Label lbSexo;

    @FXML
    private Label lbCorreo;

    @FXML
    private Label lbTelefono;

    @FXML
    private Button btActDatos;

    @FXML
    private Button btVolver;
    
    private Jugador jugador;
    private CPerfilJugador vPerfilJugador;
    
	public void initialize(URL location, ResourceBundle resources) {
		btActDatos.setOnAction(new Acciones());
		btVolver.setOnAction(new Acciones());
		actualizar(jugador);
	}

	public void actualizar(Jugador jugador) {
		this.jugador = jugador;

		//lbNombre.setText(jugador.getJugador().getNombre());
		//lbApellido.setText(jugador.getJugador().getApellido());
		//lbCorreo.setText(jugador.getJugador().getCorreo());
		//lbSexo.setText(jugador.getJugador().getSexo());
		//lbTelefono.setText(jugador.getJugador().getTelefono());
		//lbDni.setText(jugador.getJugador().getDni());
    }
	
	class Acciones implements EventHandler<ActionEvent>{
    	@Override
		public void handle(ActionEvent event) {
    		if(event.getSource() == btActDatos) {
    			try {
		            CActDatosJugador j = new CActDatosJugador(jugador, vPerfilJugador);
		            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VactDatosJugador.fxml"));
		            loader.setController(j);
		            Parent root = loader.load();

					Stage stages = new Stage();
					stages.setScene(new Scene(root));

					stages.show();
		            
		            
				} catch (Exception e) {
					e.printStackTrace();
			    }
    		}
    		else if(event.getSource() == btVolver) {
    			btVolver.getScene().getWindow().hide();

    		}

    	}
    }
	
}
