package curso.java.tienda.modelo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Indica que este campo es el identificador único de la entidad en la base de
	// datos.
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// @NotBlank
	private int rol;

	// Indica que este campo no puede ser nulo ni estar en blanco.
	// @NonNull
	private String email;
	// @Nonnull
	private String clave;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	// Indica que este campo no puede ser nulo ni estar en blanco, y muestra un
	// mensaje de error personalizado.
	// @Nonnull
	private String nombre;

	// Indica que este campo no puede ser nulo ni estar en blanco, y muestra un
	// mensaje de error personalizado.
	// @Nonnull
	private String apellidos;
	private String direccion;
	private String provincia;
	private String localidad;
	private String telefono;
	private String dni;

	private boolean baja;

//	public Object getEmail() {
//		// TODO Auto-generated method stub
//		return email;
//	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
