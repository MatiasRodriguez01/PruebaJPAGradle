package org.example.entidades;

import org.example.entidades.enums.Rol;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

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

    @Column(name = "tipo_empleado")
    private Rol tipoEmpleado;

    // Relaciones

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_imagen_empleado")
    private Imagen imagenEmpleado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario_empleado")
    private Usuario usuario_Empleado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_sucursal")
    private Sucursal sucursal;

    //Constructores
    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEmpleado = tipo;
    }

    public Empleado(String nombre, String apellido, String telefono,String email, LocalDate fechaNacimiento, Rol tipo, Imagen imagenEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEmpleado = tipo;
        this.imagenEmpleado = imagenEmpleado;
    }

    public Empleado(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol tipo, Imagen imagenEmpleado, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEmpleado = tipo;
        this.imagenEmpleado = imagenEmpleado;
        this.usuario_Empleado = usuario;
    }

    public Empleado(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol tipo, Imagen imagenEmpleado, Usuario usuario, Sucursal sucursal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEmpleado = tipo;
        this.imagenEmpleado = imagenEmpleado;
        this.usuario_Empleado = usuario;
        this.sucursal = sucursal;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Rol getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(Rol tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Imagen getImagenEmpleado() {
        return imagenEmpleado;
    }

    public void setImagenEmpleado(Imagen imagenEmpleado) {
        this.imagenEmpleado = imagenEmpleado;
    }

    public Usuario getUsuario_Empleado() {
        return usuario_Empleado;
    }

    public void setUsuario_Empleado(Usuario usuario) {
        this.usuario_Empleado = usuario;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
