package application.persistencia;

public class DataBaseTest {

	public static void main(String[] args) {
		
		//Creación de la base de datos
		
		DataBase.Conectar(false);
		System.out.println("Se ha creado y conectado la base de datos");

		DataBase.CerrarConexion();
		System.out.println("Se ha desconectado de la base de datos");
	}

}
