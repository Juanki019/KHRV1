package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControllerProximosPartidos implements Initializable{

    @FXML
    private Button btnPartidos;

    @FXML
    void actionEvent(ActionEvent event) {
    	TableView<Partido> tableViewP = new TableView();

		TableColumn<Partido, String> column1 = new TableColumn<>("Partido VS");
		column1.setCellValueFactory(new PropertyValueFactory<>("partido"));


		TableColumn<Partido, String> column2 = new TableColumn<>("Dia");
		column2.setCellValueFactory(new PropertyValueFactory<>("dia"));

		TableColumn<Partido, String> column3 = new TableColumn<>("Competicion");
		column3.setCellValueFactory(new PropertyValueFactory<>("competicion"));
		
		tableViewP.getColumns().add(column1);
		tableViewP.getColumns().add(column2);
		tableViewP.getColumns().add(column3);




		//Add data to the TableView!
		String jsonString = "[{\"partido\":\"Alcoyano\", \"dia\":\"1/2/2023\", \"competicion\":\"Copa del Rey\" }, "
				+ "{\"partido\":\"Fuenlabrada\", \"dia\":\"7/2/2023\", \"competicion\":\"Liga\" }, "
				+ "{\"partido\":\"Villaviciosa\", \"dia\":\"15/2/2023\", \"competicion\":\"Liga\" }, "
				+ "{\"partido\":\"CityMadrid\", \"dia\":\"21/2/2023\", \"competicion\":\"Liga\" }, "
				+ "{\"partido\":\"Alcoyano\", \"dia\":\"30/2/2023\", \"competicion\":\"Copa del Rey\" }, "
				+ "{\"partido\":\"RMadrid Castilla\", \"dia\":\"7/3/2023\", \"competicion\":\"Liga\" }, "
				+ "{\"partido\":\"Boadilla\", \"dia\":\"12/3/2023\", \"competicion\":\"Liga\" }, "
				+ "{\"partido\":\"Alcorocon\", \"dia\":\"20/3/2023\", \"competicion\":\"Liga\" }, "
				+ "{\"partido\":\"Majadahonda\", \"dia\":\"25/3/2023\", \"competicion\":\"Liga\" }, "
				+ "{\"partido\":\"Cacereño\", \"dia\":\"30/3/2023\", \"competicion\":\"Liga\" }, "
				+ "{\"partido\":\"Ibiza\", \"dia\":\"6/4/2023\", \"competicion\":\"Liga\" }]";
		Gson gson = new Gson();
		Partido[] dataList = gson.fromJson(jsonString, Partido[].class);
		ObservableList<Partido> observableList = FXCollections.observableArrayList(dataList);
		tableViewP.setItems(observableList);
      
		Scene scene = new Scene(new StackPane(tableViewP));
		Stage stage = (Stage) this.btnPartidos.getScene().getWindow();//cerrar
		stage.setTitle("Partidos");
		stage.setScene(scene);
		stage.show();
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
