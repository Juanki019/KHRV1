package controller;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import usuarios_entrenador.Usuarios;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PlantillaController implements Initializable{

	@FXML
	private Button btnAnadir, btnModificar, btnEliminar, btnNuevo, btnClose;
	
	@FXML
	private TextField nombreTF, edadTF, posicionTF, telefonoTF;
	
	@FXML
	private TableView<Usuarios> tablaJugadores;
	
	@FXML
	private TableColumn nombreCL, edadCL, posicionCL, telefonoCL; 
	
	/*Array de jugadores*/
	ObservableList<Usuarios>usuarios;
	
	/*indice de posicion del jugador en tabla*/
	private int posicionJugadorTabla;
	
	@FXML
	private void nuevo(ActionEvent event) {
		nombreTF.setText("");
		edadTF.setText("");
		posicionTF.setText("");
		telefonoTF.setText("");
		btnModificar.setDisable(true);//que no se pueda usar a 0
		btnEliminar.setDisable(true);
		btnAnadir.setDisable(false);
	}
	
	@FXML
	private void anadir(ActionEvent event) {
		Usuarios usuario = new Usuarios();
		usuario.nombre.set(nombreTF.getText()); /*Lo que hay en el textfield lo pongo como atributo en el atributo jugador*/
		try {
		usuario.edad.set(Integer.parseInt(edadTF.getText()));
		}catch(Exception ew) {
            JOptionPane.showMessageDialog(null, "Edad en número por favor", "Fallo", JOptionPane.INFORMATION_MESSAGE);
		}
		usuario.posicion.set(posicionTF.getText());
		usuario.telefono.set(telefonoTF.getText());
		usuarios.add(usuario);
			
	}
	
	@FXML
	private void modificar(ActionEvent event) {
		Usuarios usuario = new Usuarios();
		usuario.nombre.set(nombreTF.getText()); /*Das al jugador va al textfield y hace lo mismo que anadir*/
		usuario.edad.set(Integer.parseInt(edadTF.getText()));
		usuario.posicion.set(posicionTF.getText());
		usuario.telefono.set(telefonoTF.getText());
		usuarios.set(posicionJugadorTabla, usuario);/* Lo guardamos en la posicion la modificacion*/
	}
	
	@FXML
	private void eliminar(ActionEvent event) {
		usuarios.remove(posicionJugadorTabla);
	}
	

	/*Para seleccionar una celda de la tabla, escucha todo el rato para ver donde hay cambios*/
	private final ListChangeListener<Usuarios> selectorTablaJugador = new ListChangeListener<Usuarios>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends Usuarios> c) {
			// TODO Auto-generated method stub
			ponerUsuarioSeleccionado();
		}
	};
	
	
	/*Cuando pulses una jugador te lo devulve*/
	public Usuarios getTablaUsuarioSeleccionado() {
		
		if(tablaJugadores != null) {
			List<Usuarios> tabla = tablaJugadores.getSelectionModel().getSelectedItems();
			if(tabla.size() == 1) {
				final Usuarios competicionSeleccionada  = tabla.get(0);
				return competicionSeleccionada;
			}
		}
		
		return null;
	}
	
	private void ponerUsuarioSeleccionado() {
		final Usuarios usuario = getTablaUsuarioSeleccionado();
		posicionJugadorTabla = usuarios.indexOf(usuario);
		
		if(usuario != null) {
			
			nombreTF.setText(usuario.getNombre().toString());
			edadTF.setText(usuario.getEdad().toString());
			posicionTF.setText(usuario.getPosicion().toString());
			telefonoTF.setText(usuario.getTelefono().toString());
			
			btnModificar.setDisable(false);//que no se pueda usar a 0
			btnEliminar.setDisable(false);
			btnAnadir.setDisable(true);
			
		}
	}
	
	private void inicializarTablaUsuarios(){
		
		nombreCL.setCellValueFactory(new PropertyValueFactory<Usuarios, String>("nombre"));
		edadCL.setCellValueFactory(new PropertyValueFactory<Usuarios, Integer>("edad"));
		posicionCL.setCellValueFactory(new PropertyValueFactory<Usuarios, String>("posicion"));
		telefonoCL.setCellValueFactory(new PropertyValueFactory<Usuarios, String>("telefono"));
		
		
		usuarios = FXCollections.observableArrayList();
		tablaJugadores.setItems(usuarios);
		
	}
	
	public static String[] generarNombresAleatorios(int cantidad) {
		String[] nombresAleatorios = new String[cantidad];

		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar"};
	
		for (int i = 0; i < cantidad; i++) {
			nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " ";
		}
		return nombresAleatorios;
	}
	



	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.inicializarTablaUsuarios();
		
		btnModificar.setDisable(true);//que no se pueda usar a 0
		btnEliminar.setDisable(true);
		
		final ObservableList<Usuarios> tablaPersonaSel = tablaJugadores.getSelectionModel().getSelectedItems();
		tablaPersonaSel.addListener(selectorTablaJugador);
	
		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar"};
		
		for(int i=0; i<20; i++) {
			Usuarios usuariop = new Usuarios();
			usuariop.nombre.set("Nombre "+i);
			usuariop.edad.set(16+i);
			usuariop.posicion.set("Dorsal "+i);
			usuariop.telefono.set("656422"+i);
			usuarios.add(usuariop);
		}
		
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
