package Usuarios;


public class Entrenador extends Usuarios{

	 private String correo;
	 private String contraseña;
	 private String nombre; 

	 
	public Entrenador(String tipoUser) {
		this.correo = correo;
		this.nombre = nombre;
		this.contraseña = contraseña;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Entrenador";
	}

	
	
	
}
