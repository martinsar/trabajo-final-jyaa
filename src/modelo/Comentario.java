package modelo;

import java.util.Date;
import java.util.UUID;

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
@Table(name="comentario")
public class Comentario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "comentario_id")
	private Long  comentarioId;
	
	@Column(nullable=true)
	private Date dia;
	
	@Column(nullable=true)
	private String textoComentario;
	

	@ManyToOne
	    @JoinColumn(name="recorridoId")
	private Recorrido recorrido;
	
	
    @ManyToOne
	    @JoinColumn(name="usuarioId")
	private Usuario usuario;
	
	public String getTextoComentario() {
		return textoComentario;
	}
	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}
	

	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Recorrido getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}


	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Long getComentarioId() {
		return comentarioId;
	}
	public void setComentarioId(Long comentarioId) {
		this.comentarioId = comentarioId;
	}
	



}
