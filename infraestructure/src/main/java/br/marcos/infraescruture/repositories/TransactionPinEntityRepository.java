package br.marcos.infraescruture.repositories;

import br.marcos.infraescruture.entities.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
