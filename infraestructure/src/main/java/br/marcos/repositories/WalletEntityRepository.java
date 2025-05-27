package br.marcos.repositories;

import br.marcos.entities.WallletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WallletEntity, Long> {
}
