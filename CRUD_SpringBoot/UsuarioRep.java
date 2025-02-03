package CRUD_SpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRep extends JpaRepository<Usuario, Long> {
}
