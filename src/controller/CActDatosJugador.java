package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import usuario_jugador.Jugador;
import usuario_jugador.Usuario;

public class CActDatosJugador implements Initializable{

    @FXML
    private TextField lbNewNombre;

    @FXML
    private TextField lbNewApellido;

    @FXML
    private TextField lbNewDni;

    @FXML
    private TextField lbNewSexo;

    @FXML
    private TextField lbNewCorreo;

    @FXML
    private TextField lbNewTelefono;

    @FXML
    private Button btVolverMiPerfil;
	
    private Jugador jugador;
    private List<Jugador> jugadores;
    private List<Usuario> usuarios;
    
    CPerfilJugador vPerfilJugador;
    
    public CActDatosJugador(Jugador jugador, CPerfilJugador vPerfilJugador) {
    	this.jugador = jugador;
    	//jugadores = Jugador.pullJugadores();
    	//usuarios = Usuario.pullUsuarios();
    	this.vPerfilJugador = vPerfilJugador;
    	
    }
    
    public void initialize(URL location, ResourceBundle resources) {
    	btVolverMiPerfil.setOnAction(new Acciones());
    	
    	//lbNewNombre.setText(jugador.getJugador().getNombre());
    	//lbNewApellido.setText(jugador.getJugador().getApellido());
    	//lbNewDni.setText(jugador.getJugador().getDni());
    	//lbNewSexo.setText(jugador.getJugador().getSexo());
    	//lbNewCorreo.setText(jugador.getJugador().getCorreo());
    	//lbNewTelefono.setText(jugador.getJugador().getTelefono());
    }
	
    class Acciones implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
			if(event.getSource() == btVolverMiPerfil) {
				// Actualizar el json
				for(int i = 0 ; i < jugadores.size() ; i++) {
	    			if(jugadores.get(i).getJugador().getId() == jugador.getJugador().getId()) {
	    				jugadores.get(i).getJugador().setNombre(lbNewNombre.getText());
	    				jugadores.get(i).getJugador().setApellido(lbNewApellido.getText());
	    				jugadores.get(i).getJugador().setSexo(lbNewDni.getText());
	    				jugadores.get(i).getJugador().setTelefono(lbNewSexo.getText());
	    				jugadores.get(i).getJugador().setCorreo(lbNewCorreo.getText());
	    				jugadores.get(i).getJugador().setDni(lbNewTelefono.getText());
	    				jugador = jugadores.get(i);
	    				Jugador.pushJugadores(jugadores);
	    			}
	    		}
				
				//Actualizar el json de usuarios
				for(int i = 0 ; i < usuarios.size() ; i++) {
	    			if(usuarios.get(i).getId() == jugador.getJugador().getId()) {
	    				usuarios.get(i).setNombre(lbNewNombre.getText());
	    				usuarios.get(i).setApellido(lbNewApellido.getText());
	    				usuarios.get(i).setCorreo(lbNewCorreo.getText());
	    				
	    				Usuario.pushUsuarios(usuarios);
	    			}
	    			
	    		}
				btVolverMiPerfil.getScene().getWindow().hide();
				vPerfilJugador.actualizar(jugador);
			}
			
		}
    	
    }
	
}
