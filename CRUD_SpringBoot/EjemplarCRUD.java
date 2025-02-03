package CRUD_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EjemplarCRUD {

    @Autowired
    private EjemplarRep ejemplarRepository;

    // Crear ejemplar
    public Ejemplar crearEjemplar(Ejemplar ejemplar) {
        return ejemplarRepository.save(ejemplar);
    }

    // Obtener todos los ejemplares
    public List<Ejemplar> obtenerEjemplares() {
        return ejemplarRepository.findAll();
    }

    // Obtener ejemplar por ID
    public Optional<Ejemplar> obtenerEjemplarPorId(Long id) {
        return ejemplarRepository.findById(id);
    }

    // Actualizar ejemplar
    public Ejemplar actualizarEjemplar(Long id, Ejemplar ejemplar) {
        if (ejemplarRepository.existsById(id)) {
            ejemplar.setId(id);
            return ejemplarRepository.save(ejemplar);
        }
        return null; // Retorna null si no existe el ejemplar
    }

    // Eliminar ejemplar
    public boolean eliminarEjemplar(Long id) {
        if (ejemplarRepository.existsById(id)) {
            ejemplarRepository.deleteById(id);
            return true;
        }
        return false; // Retorna false si no existe el ejemplar
    }
}
