package org.example.entidades;

import org.example.entidades.enums.Rol;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Cliente")
public class Cliente  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_de_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "tipo_cliente")
    private Rol tipoCliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_imagen_cliente")
    private Imagen imagenCliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario_cliente")
    private Usuario usuario_Cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoCliente = tipo;
    }

    public Cliente(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol tipo, Imagen imagenCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoCliente = tipo;
        this.imagenCliente = imagenCliente;
    }

    public Cliente(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol tipo, Imagen imagenCliente, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoCliente = tipo;
        this.imagenCliente = imagenCliente;
        this.usuario_Cliente = usuario;
    }

    public Cliente(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol tipo, Imagen imagenCliente, Usuario usuario, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoCliente = tipo;
        this.imagenCliente = imagenCliente;
        this.usuario_Cliente = usuario;
        this.domicilio = domicilio;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Rol getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Rol tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Imagen getImagenCliente() {
        return imagenCliente;
    }

    public void setImagenCliente(Imagen imagenCliente) {
        this.imagenCliente = imagenCliente;
    }

    public Usuario getUsuario_Cliente() {
        return usuario_Cliente;
    }

    public void setUsuario_Cliente(Usuario usuario) {
        this.usuario_Cliente = usuario;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}

