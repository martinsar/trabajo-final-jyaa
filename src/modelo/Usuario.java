package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;






@Entity
@Table(name="usuario")
public class Usuario {
	
	public Usuario() {
		
	}
	
	@Id
	@GeneratedValue
	private Long  usuarioId;
	
	@Column(nullable=true)
	private String userName;
	
	@Column(nullable=true)
	private String password;
	
	@Column(nullable=true)
	private String nombre;
	
	@Column(nullable=true)
	private String apellido;
	
	@Column(nullable=true)
	private String domicilio;
	
	@ElementCollection
	private List<String> telelefono;
	
	@Column(nullable=true)
	private String email;
	
	@Column(nullable=true)
	private String empresa_organizacion;
	
	@Column(nullable=true)
	private String personaContacto;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comentario> comentarios;
	
	@OneToMany
	private List<Donacion> donaciones;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Recorrido> recorridos;

	@ElementCollection
	private List<String> horariosContacto;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Usuario> usuarios;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="rol_id")
	private Rol rol;;

	
	
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public List<String> getTelelefono() {
		return telelefono;
	}
	public void setTelelefono(List<String> telelefono) {
		this.telelefono = telelefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmpresa_organizacion() {
		return empresa_organizacion;
	}
	public void setEmpresa_organizacion(String empresa_organizacion) {
		this.empresa_organizacion = empresa_organizacion;
	}
	public String getPersonaContacto() {
		return personaContacto;
	}
	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}
	
	public List<String> getHorariosContacto() {
		return horariosContacto;
	}
	public void setHorariosContacto(List<String> horariosContacto) {
		this.horariosContacto = horariosContacto;
	}
	/*
	
	public List<Donacion> getDonaciones() {
		return donaciones;
	}
	public void setDonaciones(List<Donacion> donaciones) {
		this.donaciones = donaciones;
	}
	
	
	*/
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Donacion> getDonaciones() {
		return donaciones;
	}
	public void setDonaciones(List<Donacion> donaciones) {
		this.donaciones = donaciones;
	}
	public List<Recorrido> getRecorridos() {
		return recorridos;
	}
	public void setRecorridos(List<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	

}
