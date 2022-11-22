package com.gestion.inventario.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
@Table(name = "medicamentos")
public class Medicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "cantidad", length = 60, nullable = false)
    private int cantidad;

    @Column(name = "stock", length = 60, nullable = false)
    private int stock;

    @Column(name = "precio", length = 60, nullable = false)
    private int precio;

    @Column(name = "fechavencimiento", length = 60, nullable = false)
    private String fechaV;

    public Medicamentos() {

    }

    public Medicamentos(Long id, String nombre, int cantidad, int stock, int precio, String fechaV) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.stock = stock;
        this.precio = precio;
        this.fechaV = fechaV;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFechaV() {
        return fechaV;
    }

    public void setFechaV(String fechaV) {
        this.fechaV = fechaV;
    }

}
