package modelo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "producto_id")
	private Long id;
	
	@Column(nullable=true)
	private String tipo; 
	
	@Column(nullable=true)
	private String marca;
	
	@Column(nullable=true)
	private Integer cantidadUnidades;
	
	@Column(nullable=true)
	private Date fechaVencimiento;
	
	@Column(nullable=true)
	private Double peso;
	
	@Column(nullable=true)
	private Double capacidadPorEnvase;
	
	@ManyToOne
    @JoinColumn(name="donacionId")
	private Donacion donacion;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getCantidadUnidades() {
		return cantidadUnidades;
	}
	public void setCantidadUnidades(Integer cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getCapacidadPorEnvase() {
		return capacidadPorEnvase;
	}
	public void setCapacidadPorEnvase(Double capacidadPorEnvase) {
		this.capacidadPorEnvase = capacidadPorEnvase;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Donacion getDonacion() {
		return donacion;
	}
	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}
}
