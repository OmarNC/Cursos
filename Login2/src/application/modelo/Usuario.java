package application.modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private transient SimpleStringProperty usuario = new SimpleStringProperty();
	private transient SimpleStringProperty password = new SimpleStringProperty();
	
	
	
	public Usuario(String user, String passwd)
	{
		this.usuario.set(user);
		this.password.set(passwd);
	}
	
	
	@Override
	public String toString()
	{
		return "<User: " + usuario + ", Contraseña: " + password + ">";
	}
	
	
	
	public String getUsuario()
	{
		return usuario.get();
	}
	
	public void setUsuario(String nuevoUsuario)
	{
		this.usuario.set(nuevoUsuario);
	}
	
	
	public final StringProperty usuarioProperty() {
	    return usuario;
	}
	


	
	public void setPassword(String nuevoPassword)
	{
		this.password.set(nuevoPassword);
	}
	
	public String getPassword()
	{
		return password.get();
	}
	public final StringProperty passwordProperty() {
	    return password;
	}
	

	
	
	
	
	@Override
	public boolean equals(Object obj)
	{
		boolean result = false;
		if (obj instanceof Usuario)
		{
			Usuario user2 = (Usuario)obj;
			result = this.usuario.get().equals(user2.usuario.get()) &&
					this.password.get().equals(user2.password.get());
		}
		return result;
	}
	
	public static boolean verificarCredenciales(Usuario user1, Usuario user2) {
		
		return user1.equals(user2);
	}
	
	@Serial
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		
		in.defaultReadObject();
		this.usuario = new SimpleStringProperty();
		this.usuario.set(in.readUTF());
		this.password = new SimpleStringProperty();
		this.password.set(in.readUTF());
	}
	
	@Serial
	private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.defaultWriteObject();
		out.writeUTF(this.usuario.get());
		out.writeUTF(this.password.get());
	}
	
	
}
