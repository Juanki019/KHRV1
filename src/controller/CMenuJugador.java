package controller;

import javafx.fxml.Initializable;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import usuario_jugador.Jugador;

public class CMenuJugador implements Initializable{

    @FXML
    private Label lblNombreJugador;

    @FXML
    private VBox miPerfil;

    @FXML
    private VBox interactuar;

    @FXML
    private VBox graficas;

    @FXML
    private HBox cerrarSesion;
    
    private Jugador jugador;
    private List<Jugador> jugadores;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	//lblNombreJugador.setText(jugador.getJugador().getNombre()+" "+jugador.getJugador().getApellido());
		
		miPerfil.setOnMouseClicked(new Acciones());
    	interactuar.setOnMouseClicked(new Acciones());
    	graficas.setOnMouseClicked(new Acciones());
    	cerrarSesion.setOnMouseClicked(new Acciones());
	}
    
    class Acciones implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() == miPerfil) {
				try {
		            CPerfilJugador j = new CPerfilJugador();
		            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VperfilJugador.fxml"));
		            loader.setController(j);
		            Parent root = loader.load();

					Stage stages = new Stage();
					stages.setScene(new Scene(root));

					stages.show();
		            
		            
				} catch (Exception e) {
					e.printStackTrace();
			    }
			}
		}

    	
    }
}
