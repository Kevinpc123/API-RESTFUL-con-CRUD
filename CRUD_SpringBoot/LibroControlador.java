package CRUD_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@CacheConfig(cacheNames = {"cacheLibro"})
@RequestMapping("/libros")
public class LibroControlador {

    @Autowired
    private LibroCRUD libroService;

    @PostMapping
    public ResponseEntity<?> crearLibro(@Valid @RequestBody Libro libro, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors= new StringBuilder();
            for(FieldError error : bindingResult.getFieldErrors()){
                errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.badRequest().body(errors.toString());
        }
        return ResponseEntity.ok(libroService.crearLibro(libro));
    }

    @GetMapping
    public List<Libro> obtenerLibros() {
        return libroService.obtenerLibros();
    }

    @GetMapping("/{isbn}")
    public Libro obtenerLibroPorIsbn(@PathVariable String isbn) {
        return libroService.obtenerLibroPorIsbn(isbn);
    }

    @PutMapping("/{isbn}")
    public Libro actualizarLibro(@PathVariable String isbn, @RequestBody @Valid Libro libro) {
        return libroService.actualizarLibro(isbn, libro);
    }

    @DeleteMapping("/{isbn}")
    public boolean eliminarLibro(@PathVariable String isbn) {
        return libroService.eliminarLibro(isbn);
    }
}
