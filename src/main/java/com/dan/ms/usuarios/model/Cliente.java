package com.dan.ms.usuarios.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String razonSocial;

    @NotBlank
    @Pattern(regexp = "[0-9]+")
    @Size(min = 11, max = 11)
    private String cuit;

    @NotBlank
    @Email
    private String mail;

    @NotBlank
    @PositiveOrZero
    private BigDecimal maximoCuentaCorriente;

    private Boolean habilitadoOnline;

    @NotEmpty
    @OneToOne
    private Usuario usuario;

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuil) {
        this.cuit = cuil;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public BigDecimal getMaximoCuentaCorriente() {
        return maximoCuentaCorriente;
    }

    public void setMaximoCuentaCorriente(BigDecimal maximoCuentaCorriente) {
        this.maximoCuentaCorriente = maximoCuentaCorriente;
    }

    public Boolean getHabilitadoOnline() {
        return habilitadoOnline;
    }

    public void setHabilitadoOnline(Boolean habilitadoOnline) {
        this.habilitadoOnline = habilitadoOnline;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
