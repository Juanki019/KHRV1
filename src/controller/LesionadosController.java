package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import usuarios_entrenador.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LesionadosController implements Initializable {

    @FXML
    private PieChart chart,chart2;

    @FXML
    private Button btnVerLesionados;
	
    
    @FXML
    void actionEvent(ActionEvent event) {

    	TableView<Jugador> tableView = new TableView();

		TableColumn<Jugador, String> column1 = new TableColumn<>("Nombre");
		column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));


		TableColumn<Jugador, String> column2 = new TableColumn<>("Posicion");
		column2.setCellValueFactory(new PropertyValueFactory<>("posicion"));

		TableColumn<Jugador, String> column3 = new TableColumn<>("Lesion");
		column3.setCellValueFactory(new PropertyValueFactory<>("lesion"));
		
		TableColumn<Jugador, String> column4 = new TableColumn<>("Gravedad");
		column4.setCellValueFactory(new PropertyValueFactory<>("gravedad"));

		tableView.getColumns().add(column1);
		tableView.getColumns().add(column2);
		tableView.getColumns().add(column3);
		tableView.getColumns().add(column4);



		//Add data to the TableView!
		String jsonString = "[{\"nombre\":\"Cristiano\", \"posicion\":\"Delantero\", \"lesion\":\"Sobrecraga muslo\", \"gravedad\":\"medio\"}, "
				+ "{\"nombre\":\"Felipe\", \"posicion\":\"Defensa\", \"lesion\":\"Sobrecarga gemelo\", \"gravedad\":\"leve\" }, "
				+ "{\"nombre\":\"Samu\", \"posicion\":\"Defensa\", \"lesion\":\"muñeca\", \"gravedad\":\"leve\" }, "
				+ "{\"nombre\":\"Miguel\", \"posicion\":\"Lateral\", \"lesion\":\"Sobrecarga gemelo\", \"gravedad\":\"leve\" }]";
		Gson gson = new Gson();
		Jugador[] dataList = gson.fromJson(jsonString, Jugador[].class);
		ObservableList<Jugador> observableList = FXCollections.observableArrayList(dataList);
		tableView.setItems(observableList);
      
		Scene scene = new Scene(new StackPane(tableView));
		Stage stage = (Stage) this.btnVerLesionados.getScene().getWindow();//cerrar
		stage.setTitle("Lesionados");
		stage.setScene(scene);
		stage.show();
    	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<PieChart.Data>chartDisponibilidadData = 
    			FXCollections.observableArrayList(new PieChart.Data("Disponibles", 80), 
    					new PieChart.Data("Lesionados", 15),
    					new PieChart.Data("Tocados", 5));
    	
    	chart.getData().addAll(chartDisponibilidadData);
    	
		ObservableList<PieChart.Data>chartDisponibilidadData2 = 
    			FXCollections.observableArrayList(new PieChart.Data("Sobrecarga Muslo", 50), 
    					new PieChart.Data("Sobrecarga Gemelo", 25),
    					new PieChart.Data("Muñeca", 25));
    	
    	chart2.getData().addAll(chartDisponibilidadData2);
	}
    
}
