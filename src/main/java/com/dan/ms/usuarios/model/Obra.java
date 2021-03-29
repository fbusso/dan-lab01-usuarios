package com.dan.ms.usuarios.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 255)
    private String descripcion;

    @NotBlank
    @Size(min = 1, max = 100)
    private String direccion;

    @NotBlank
    @DecimalMin("-90.000000")
    @DecimalMax("90.000000")
    private Double latitud;

    @NotBlank
    @DecimalMin("-180.000000")
    @DecimalMax("180.000000")
    private Double longitud;

    @NotBlank
    @Positive
    @Size(min = 1)
    private Integer superficie;

    @NotBlank
    @ManyToOne
    private TipoObra tipoObra;

    @NotBlank
    @ManyToOne
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public TipoObra getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(TipoObra tipoObra) {
        this.tipoObra = tipoObra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
