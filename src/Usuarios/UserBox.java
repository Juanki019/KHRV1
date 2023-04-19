package Usuarios;

public class UserBox {

    private String tipoUser2;

	public UserBox(String tipoUser2) {
		super();
		this.tipoUser2 = tipoUser2;
	}
	@Override
	public String toString() {
		return "Usuario: " + tipoUser2 ;
	}
	
}
