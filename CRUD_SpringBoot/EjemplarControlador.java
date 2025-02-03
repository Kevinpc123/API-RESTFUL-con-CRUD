package CRUD_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ejemplares")
public class EjemplarControlador {

    @Autowired
    private EjemplarCRUD ejemplarService;

    // Crear ejemplar
    @PostMapping
    public ResponseEntity<Ejemplar> crearEjemplar(@RequestBody @Valid Ejemplar ejemplar) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ejemplarService.crearEjemplar(ejemplar));
    }

    // Obtener lista de ejemplares
    @GetMapping
    public List<Ejemplar> obtenerEjemplares() {
        return ejemplarService.obtenerEjemplares();
    }

    // Obtener ejemplar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> obtenerEjemplarPorId(@PathVariable Long id) {
        Optional<Ejemplar> ejemplar = ejemplarService.obtenerEjemplarPorId(id);
        return ejemplar.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Actualizar ejemplar
    @PutMapping("/{id}")
    public ResponseEntity<Ejemplar> actualizarEjemplar(@PathVariable Long id, @RequestBody @Valid Ejemplar ejemplar) {
        Ejemplar updatedEjemplar = ejemplarService.actualizarEjemplar(id, ejemplar);
        if (updatedEjemplar == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedEjemplar);
    }

    // Eliminar ejemplar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEjemplar(@PathVariable Long id) {
        if (ejemplarService.eliminarEjemplar(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Manejar excepciones de validación
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationExceptions(ValidationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
