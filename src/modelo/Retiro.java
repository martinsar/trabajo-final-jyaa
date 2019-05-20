package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="retiro")
public class Retiro {
	
	@Id
	@GeneratedValue
	private Long  retiroId;
	
	@Column(nullable=false)
	private Date fechaHoraRetiro;
	
	@ManyToOne
    @JoinColumn(name="donacionId")
	private Donacion donacion;
	
	@ManyToOne
    @JoinColumn(name="recorridoId")
	private Recorrido recorrido;
	
	public Date getFechaHoraRetiro() {
		return fechaHoraRetiro;
	}
	public void setFechaHoraRetiro(Date fechaHoraRetiro) {
		this.fechaHoraRetiro = fechaHoraRetiro;
	}
	public Donacion getDonacion() {
		return donacion;
	}
	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}
	public Recorrido getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	public Long getRetiroId() {
		return retiroId;
	}
	public void setRetiroId(Long retiroId) {
		this.retiroId = retiroId;
	}

}
