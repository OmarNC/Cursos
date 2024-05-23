package application.persistencia;

import java.util.ArrayList;

import application.modelo.Producto;

public class ProductosHelperTest {

	public static void main(String[] args) {
		
		System.out.println("Eliminando la tabla Productos...\n");
		//Eliminar la tabla
		ProductosHelper.eliminarTable();
		
		
		System.out.println("Creando latabla Productos...\n");
		// Crear la Tabla productos
		ProductosHelper.createTable();
		
		System.out.println("Agregando registros a la tabla Productos...\n");
		//Agrega productos a la tabla
		ProductosHelper.addProducto(new Producto(1, "Lapiz", "HB marca Mirado", 15));
		ProductosHelper.addProducto(new Producto(2, "Goma", "Blanca Pelikan", 10));
		ProductosHelper.addProducto(new Producto(3, "Cuaderno", "Scribe raha", 45));
		ProductosHelper.addProducto(new Producto(4, "SN", "SD", 0));
		
		System.out.println("Recuperar los registros de la tabla Productos...\n");
		ArrayList<Producto> lista = ProductosHelper.getAllProducto();
		
		System.out.println("Lista de Productos");
		System.out.println("----------------------------------");

		for(Producto p : lista)
		{
			System.out.println(p);
		}
		System.out.println("----------------------------------\n");

		
		System.out.println("Buscar el Productos con ID = 4: ");
		
		Producto p1 = ProductosHelper.getProducto(4);
		System.out.println(p1);

		
		p1.setNombre("Hojas blancas");
		p1.setDescripcion("200 hojas t/carta marca Scribe");
		p1.setPrecio(60);

		System.out.println("\nObjeto Productos con ID = 4 modificado: ");
		System.out.println(p1);
		System.out.println();
		
				
		System.out.println("Actualizando el Productos con ID = 4 en la base de datos...\n");
		ProductosHelper.UpdateProducto(p1);
		
		System.out.println("Leer la lista de productos de la Base de datos ...\n");
		lista = ProductosHelper.getAllProducto();
		
		System.out.println("Lista de Productos recuperada");
		System.out.println("----------------------------------");
		for(Producto p : lista)
		{
			System.out.println(p);
		}
		System.out.println("----------------------------------\n");
		

		System.out.println("Borrar el Productos con ID = 4 en la base de datos ...\n");

		ProductosHelper.DeleteProducto(p1);
		
		System.out.println("Leer la lista de productos de la Base de datos ...\n");
		 lista = ProductosHelper.getAllProducto();
		
			System.out.println("Lista de Productos recuperada");
			System.out.println("----------------------------------");
		for(Producto p : lista)
		{
			System.out.println(p);
		}
		System.out.println("----------------------------------\n");
		
		
		
		
	}

}
