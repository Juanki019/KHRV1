package usuarios_entrenador;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;



public class Usuarios {

	/* objeto en tabla */
    public SimpleStringProperty nombre = new SimpleStringProperty() ; 
    public SimpleIntegerProperty edad = new SimpleIntegerProperty();
    public SimpleStringProperty posicion = new SimpleStringProperty();
    public SimpleStringProperty telefono = new SimpleStringProperty();
    public SimpleStringProperty lesion = new SimpleStringProperty();
    public SimpleStringProperty gravedad = new SimpleStringProperty();


	public String getNombre() {
		return nombre.get();
	}
	

	public Integer getEdad() {
		return edad.get();
	}


	public String getPosicion() {
		return posicion.get();
	}
	

	public String getTelefono() {
		return telefono.get();
	}
	
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data{Nombre=").append(nombre);
        sb.append(", Posición=").append(posicion);
        sb.append(", Lesion=").append(lesion);
        sb.append(", Gravedad=").append(gravedad);

        sb.append('}');
        return sb.toString();
    }    
    
	
}
