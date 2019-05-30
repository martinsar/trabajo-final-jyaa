package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {
	
	public Rol() {
	}
	
	/**
	 * @param nombreRol
	 */
	public Rol(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "rol_id")
	private Long id;
	
	
	@Column(nullable=true)
	private String nombreRol;
	

	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
