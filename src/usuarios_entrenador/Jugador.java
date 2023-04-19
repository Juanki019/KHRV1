package usuarios_entrenador;

public class Jugador {

	
		private String nombre;
	    private String posicion;
	    private String lesion;
	    private String gravedad;


	    public Jugador(String nombre, String posicion, String lesion, String gravedad) {
	        this.nombre = nombre;
	        this.lesion = lesion;
	        this.posicion = posicion;
	        this.gravedad = gravedad;

	    }


	    
	    public String getLesion() {
			return lesion;
		}


		public void setLesion(String lesion) {
			this.lesion = lesion;
		}


		public String getPosicion() {
			return posicion;
		}
		

		public void setPosicion(String posicion) {
			this.posicion = posicion;
		}


		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getGravedad() {
			return gravedad;
		}

		public void setGravedad(String gravedad) {
			this.gravedad = gravedad;
		}

		
		@Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Data{nombre=").append(nombre);
	        sb.append(", posicion=").append(posicion);
	        sb.append(", lesion=").append(lesion);
	        sb.append(", gravedad=").append(gravedad);


	        sb.append('}');
	        return sb.toString();
	    }    
}
