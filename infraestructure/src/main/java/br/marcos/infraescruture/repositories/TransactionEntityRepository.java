package br.marcos.infraescruture.repositories;

import br.marcos.infraescruture.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
