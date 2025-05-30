package br.marcos.infraescruture.repositories;

import br.marcos.infraescruture.entities.WallletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WallletEntity, Long> {
    WallletEntity findByUserTaxNumber(String taxNumber);
}
