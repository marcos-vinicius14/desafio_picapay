package br.marcos.infraescruture.repositories;

import br.marcos.infraescruture.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByTaxNumber(String taxNumber);
    Boolean existsByEmail(String email);

}
