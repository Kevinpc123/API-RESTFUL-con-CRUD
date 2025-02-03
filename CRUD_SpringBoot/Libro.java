package CRUD_SpringBoot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Libro {

    @Id
    @Column(name = "isbn")
    @NotNull(message = "El ISBN no puede ser nulo.")
    @Pattern(regexp = "^\\d{3}-\\d-\\d{2}-\\d{6}-\\d$", message = "El ISBN debe tener un formato correcto (978-0-12-234567-9).")
    private String isbn;

    @Column(name = "titulo")
    @NotNull(message = "El título no puede ser nulo.")
    @Size(max = 200, message = "El título no puede tener más de 200 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "El libro solo puede contener caracteres alfanuméricos")
    private String titulo;

    @Column(name = "autor")
    @NotNull(message = "El autor no puede ser nulo.")
    @Size(max = 100, message = "El autor no puede tener más de 100 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "El autor solo puede contener caracteres alfanuméricos")
    private String autor;

    // Getters y Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
