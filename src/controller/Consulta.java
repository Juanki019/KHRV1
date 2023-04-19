package controller;

public class Consulta {

	String dia;
	String lugar;
	String hora;
	
	
	public Consulta(String dia, String lugar, String hora) {
		super();
		this.dia = dia;
		this.lugar = lugar;
		this.hora = hora;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data{lugar=").append(lugar);
        sb.append(", dia=").append(dia);
        sb.append(", hora=").append(hora);

        sb.append('}');
        return sb.toString();
    }    
	
}
