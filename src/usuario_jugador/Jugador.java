package usuario_jugador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import usuario_jugador.Jugador;
import usuario_jugador.Usuario;

public class Jugador {

	public static final String FICHERO_JUGADOR = "./json/jugadores.json";
	
	private Usuario jugador;
	
	public Jugador(Usuario jugador) {
		this.jugador = jugador;
	}
	
	public static List<Jugador> pullJugadores() {
    	
    	List<Jugador> jugador = null;
    	
    	try (Reader reader = new FileReader(FICHERO_JUGADOR)) {
			Gson gson = new Gson();
			Type tipoListaEmpleados = new TypeToken<Vector<Jugador>>(){}.getType();
			jugador = gson.fromJson(reader, tipoListaEmpleados);
			
			if(jugador == null) {
				jugador = new ArrayList<Jugador>();
			}
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	return jugador;
	}
	
	public static void pushJugadores(List<Jugador> jugador) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(FICHERO_JUGADOR)){
			prettyGson.toJson(jugador, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public Usuario getJugador() {
		return jugador;
	}
}
