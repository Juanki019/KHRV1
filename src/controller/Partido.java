package controller;


public class Partido {

	private String partido;
    private String dia;
    private String competicion;

       
	
	public Partido(String partido, String dia, String competicion) {
		super();
		this.partido = partido;
		this.dia = dia;
		this.competicion = competicion;
	}



	public String getPartido() {
		return partido;
	}



	public void setPartido(String partido) {
		this.partido = partido;
	}



	public String getDia() {
		return dia;
	}



	public void setDia(String dia) {
		this.dia = dia;
	}



	public String getCompeticion() {
		return competicion;
	}



	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}



	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data{partido=").append(partido);
        sb.append(", dia=").append(dia);
        sb.append(", competicion=").append(competicion);

        sb.append('}');
        return sb.toString();
    }    
	
}
