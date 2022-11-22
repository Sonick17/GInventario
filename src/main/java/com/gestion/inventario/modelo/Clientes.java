package com.gestion.inventario.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")

public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Long id_cli;
	
	@Column(name = "nombre_cli", nullable = false)
    private String nombre_cli;
	
	@Column(name = "apellido_cli", nullable = false)
	private String apellido_cli;
	
	@Column(name = "telefono_cli", nullable = false)
	private int telefono_cli;
	
	@Column(name = "correo", unique = true, nullable = true)
	private String correo;  
	
	public Clientes() {
		
	}

	public Clientes(Long id_cli, String nombre_cli, String apellido_cli, int telefono_cli, String correo) {
		super();
		this.id_cli = id_cli;
		this.nombre_cli = nombre_cli;
		this.apellido_cli = apellido_cli;
		this.telefono_cli = telefono_cli;
		this.correo = correo;
	}

	public Long getId_cli() {
		return id_cli;
	}

	public void setId_cli(Long id_cli) {
		this.id_cli = id_cli;
	}

	public String getNombre_cli() {
		return nombre_cli;
	}

	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}

	public String getApellido_cli() {
		return apellido_cli;
	}

	public void setApellido_cli(String apellido_cli) {
		this.apellido_cli = apellido_cli;
	}

	public int getTelefono_cli() {
		return telefono_cli;
	}

	public void setTelefono_cli(int telefono_cli) {
		this.telefono_cli = telefono_cli;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
	

	
