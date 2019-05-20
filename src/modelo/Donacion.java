package modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="donacion")
public class Donacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long donacionId;
	
	@Column(nullable=true)
	private String sucursal;
	
	@Column(nullable=true)
	private String direccionRetiro;
	
	@Column(nullable=true)
	private Date horaDeRetiro;
	
	@Column(nullable=true)
	private Date fechaDisponibilidad;
	
	@Column(nullable=true)
	private Integer longitud;
	
	@Column(nullable=true)
	private Integer latitud;
	
	@Column(nullable=true)
	private boolean retirado;
	
	
	@ManyToOne
    @JoinColumn(name="recorridoId")
	private Recorrido recorrido;
//	private List<Producto> productos;
	
	@ManyToOne
    @JoinColumn(name="retiroId")
	private Retiro retiro;

	@Column(nullable=true)
	private Integer nroRemito;

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getDireccionRetiro() {
		return direccionRetiro;
	}

	public void setDireccionRetiro(String direccionRetiro) {
		this.direccionRetiro = direccionRetiro;
	}

	public Date getFechaDisponibilidad() {
		return fechaDisponibilidad;
	}

	public void setFechaDisponibilidad(Date fechaDisponibilidad) {
		this.fechaDisponibilidad = fechaDisponibilidad;
	}

	public Integer getLongitud() {
		return longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

	public Integer getLatitud() {
		return latitud;
	}

	public void setLatitud(Integer latitud) {
		this.latitud = latitud;
	}

	public boolean isRetirado() {
		return retirado;
	}

	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}

	public Integer getNroRemito() {
		return nroRemito;
	}

	public void setNroRemito(Integer nroRemito) {
		this.nroRemito = nroRemito;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	/*
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

*/

	public Date getHoraDeRetiro() {
		return horaDeRetiro;
	}

	public void setHoraDeRetiro(Date horaDeRetiro) {
		this.horaDeRetiro = horaDeRetiro;
	}

	public Retiro getRetiro() {
		return retiro;
	}

	public void setRetiro(Retiro retiro) {
		this.retiro = retiro;
	}


	public Long getDonacionId() {
		return donacionId;
	}

	public void setDonacionId(Long donacionId) {
		this.donacionId = donacionId;
	}
}
