package modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recorrido")
public class Recorrido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "recorrido_id")
	private Long recorridoId;
	
	@Column(nullable=false)
	private Date fechaRetiro;
	
	
	 @ManyToOne
	    @JoinColumn(name="usuarioId")
	private Usuario usuario;
	 
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comentario> comentarios; 
 
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Retiro> retiros;
	
	

	

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Long getRecorridoId() {
		return recorridoId;
	}

	public void setRecorridoId(Long recorridoId) {
		this.recorridoId = recorridoId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}





	public List<Retiro> getRetiros() {
		return retiros;
	}

	public void setRetiros(List<Retiro> retiros) {
		this.retiros = retiros;
	}




}
