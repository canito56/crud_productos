package com.jb.productmodel;

import java.sql.Date;

public class Producto {
	private int id;
	private String nombre;
	private double cantidad;
	private double precio;
	private Date fecha_crear;
	private Date fecha_actualizar;
	
	public Producto(int id, String nombre, double cantidad, double precio, Date fecha_crear, Date fecha_actualizar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha_crear = fecha_crear;
		this.fecha_actualizar = fecha_actualizar;
	}
	
	public Producto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha_crear() {
		return fecha_crear;
	}

	public void setFecha_crear(Date fecha_crear) {
		this.fecha_crear = fecha_crear;
	}

	public Date getFecha_actualizar() {
		return fecha_actualizar;
	}

	public void setFecha_actualizar(Date fecha_actualizar) {
		this.fecha_actualizar = fecha_actualizar;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", fecha_crear=" + fecha_crear + ", fecha_actualizar=" + fecha_actualizar + "]";
	}

}
