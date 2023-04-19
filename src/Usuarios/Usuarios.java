package Usuarios;

import javax.swing.JOptionPane;



public class Usuarios {

    private String nombre; 
    private String correo;
    private String contraseña;
    private String tipoUser;

    
	public Usuarios(/*String tipoUser, String correo, String nombre, String contraseña*/) {
		this.tipoUser = tipoUser;
		this.correo = correo;
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
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
	


/*Entrenador - eliminar jugadores
 
 *	    	JSONObject obj = new JSONObject();
	    	JSONArray registrados = new JSONArray();
	    	int size = registrados.size();

	    	obj.put("Email", txtUserSignIn.getText());
	    	obj.put("Email", txtPasswordSignIn.getText());
	    	
	    	for(int i=0;i<size;i++) {
	    		
		    	if(obj.equals(registrados.get(i))) {
		    	registrados.remove(i)
	                JOptionPane.showMessageDialog(null, "REMOVED" , JOptionPane.INFORMATION_MESSAGE);
	                break;
		    	}else if(i==size-1){
		    		
	                JOptionPane.showMessageDialog(null, "Comprueba si has insertado la informacion bien", "ERROR", JOptionPane.ERROR_MESSAGE);
	                cleanFields();
		    	}
	    	
	    	}
	    	
 */
	@Override
	public String toString() {
		return "Usuario: " + tipoUser ;
	}
	
	
	
}
