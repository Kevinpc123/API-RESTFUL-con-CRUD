package CRUD_SpringBoot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
public class Usuario {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "dni")
    @NotNull(message = "El DNI no puede ser nulo")
    @Pattern(regexp = "^[0-9]{8}[A-Za-z]{1}$", message = "El DNI debe tener el formato correcto (8 dígitos seguidos de una letra)")
    private String dni;

    @Column(name = "nombre")
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "El nombre solo puede contener caracteres alfanuméricos")
    private String nombre;

    @Column(name = "email")
    @NotNull(message = "El correo electrónico no puede ser nulo")
    @Email(message = "El correo electrónico debe tener un formato válido")
    @Pattern(regexp = "^[A-Za-z0-9]{1,50}@gmail\\.com$", message = "El correo electrónico debe ser de tipo @gmail.com")
    private String email;

    @Column(name = "password")
    @NotNull(message = "La contraseña no puede ser nula")
    @Size(min = 4, max = 12, message = "La contraseña debe tener entre 4 y 12 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "La contraseña solo puede contener caracteres alfanuméricos")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    @NotNull(message = "El tipo de usuario no puede ser nulo")
    private TipoUsuario tipo;

    @Column(name = "penalizacionHasta")
    private Date penalizacionHasta;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Date getPenalizacionHasta() {
        return penalizacionHasta;
    }

    public void setPenalizacionHasta(Date penalizacionHasta) {
        this.penalizacionHasta = penalizacionHasta;
    }

    // Enum para los tipos de usuario
    public enum TipoUsuario {
        normal,
        administrador
    }
}
