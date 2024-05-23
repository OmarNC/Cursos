package application.modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Producto {
	
	private SimpleIntegerProperty id = new SimpleIntegerProperty();
	private SimpleStringProperty nombre = new SimpleStringProperty();
	private SimpleStringProperty descripcion = new SimpleStringProperty();
	private SimpleDoubleProperty precio = new SimpleDoubleProperty();
	
	
	public Producto(int id, String nombre, String desc, double precio) {
		this.id.set(id);
		this.nombre.set(nombre);
		this.descripcion.set(desc);
		this.precio.set(precio);
	}
	
	
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id.set(id);
	}
	
	public final IntegerProperty idProperty() {
	    return id;
	}
	
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String nombre) {
		this.nombre.set(nombre);;
	}
	public final StringProperty nombreProperty() {
	    return nombre;
	}
	
	
	public String getDescripcion() {
		return descripcion.get();
	}
	public void setDescripcion(String descripcion) {
		this.descripcion.set(descripcion);;
	}
	public final StringProperty descripcionProperty() {
	    return descripcion;
	}
	
	
	public double getPrecio() {
		return precio.get();
	}
	public void setPrecio(double precio) {
		this.precio.set(precio);;
	}
	public final DoubleProperty precioProperty() {
	    return precio;
	}
	
	
	@Override
	public String toString()
	{
		String cad ="("+ id.get()+ ", " 
					 + nombre.get() + ", "
					 + descripcion.get() + ", "
					 + precio.get() +")";
		return cad;
	}

}
