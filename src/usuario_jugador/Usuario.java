package usuario_jugador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import usuario_jugador.Usuario;

public class Usuario {

	public static final String FICHERO_USUARIO_REGISTRADOS = "./json/usuarios.json";
	public static final String FICHERO_USUARIO_GUARDADO = "./json/usuario_guardado.json";
	
	private int id;
	
	private String nombre;
	private String apellido;
	private String tipoUsuario;
	private String correo;
	private String contrasenya;
	private String sexo;
	private String telefono;
	private String dni;
	private Timestamp timestamp;
	
	public static final String JUGADOR = "jugador";
	public static final String FAMILIAR = "familiar";
	public static final String MEDICO = "medico";
	
	public Usuario(String nombre, String apellido, String tipoUsuario, String correo, String contrasenya) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoUsuario = tipoUsuario;
		this.correo = correo;
		this.contrasenya = contrasenya;
		timestamp = new Timestamp(new Date().getTime());
	}
	
	public Usuario(String nombre, String apellido, String correo, String sexo, String telefono, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.sexo = sexo;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	public Usuario(String correo, String contrasenya) {
		this.correo = correo;
		this.contrasenya = contrasenya;
	}
	
	public static List<Usuario> pullUsuarios() {
    	
    	List<Usuario> usuarios = null;
    	
    	try (Reader reader = new FileReader(FICHERO_USUARIO_REGISTRADOS)) {
			Gson gson = new Gson();
			Type tipoListaEmpleados = new TypeToken<Vector<Usuario>>(){}.getType();
			usuarios = gson.fromJson(reader, tipoListaEmpleados);
			
			if(usuarios == null) {
				usuarios = new ArrayList<Usuario>();
			}
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	return usuarios;
	}
	
	public static void pushUsuarios(List<Usuario> usuarios) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(FICHERO_USUARIO_REGISTRADOS)){
			prettyGson.toJson(usuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static Usuario pullUsuario() {
		Usuario usuario = null;
		Gson gson = new Gson();
		try(Reader reader = new FileReader(FICHERO_USUARIO_GUARDADO)) {
			usuario = gson.fromJson(reader, Usuario.class);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public static void pushUsuario(Usuario usuario) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(FICHERO_USUARIO_GUARDADO)) {
			gson.toJson(usuario, writer);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContrasenya() {
		return contrasenya;
	}
	
	public void setContrasenya(String nuevaContrasenya) {
		this.contrasenya = nuevaContrasenya;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
