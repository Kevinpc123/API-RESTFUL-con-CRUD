package CRUD_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroCRUD {

    @Autowired
    private LibroRep libroRepository;

    // Crear libro
    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Obtener lista de libros
    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    // Obtener libro por ISBN
    public Libro obtenerLibroPorIsbn(String isbn) {
        Optional<Libro> libro = libroRepository.findById(Long.valueOf(isbn));
        return libro.orElse(null); // Si no lo encuentra, devuelve null
    }

    // Actualizar libro
    public Libro actualizarLibro(String isbn, Libro libro) {
        if (libroRepository.existsById(Long.valueOf(isbn))) {
            libro.setIsbn(isbn);
            return libroRepository.save(libro);
        }
        return null; // Si no existe el libro, no lo actualiza
    }

    // Eliminar libro
    public boolean eliminarLibro(String isbn) {
        if (libroRepository.existsById(Long.valueOf(isbn))) {
            libroRepository.deleteById(Long.valueOf(isbn));
            return true;
        }
        return false; // Si no existe, no elimina
    }
}
