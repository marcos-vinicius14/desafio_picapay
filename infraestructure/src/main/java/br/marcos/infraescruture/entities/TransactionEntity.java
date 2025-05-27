package br.marcos.infraescruture.entities;

import br.marcos.core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne
   @JoinColumn(name = "from_wallet")
   private WallletEntity fromWallet;

   @ManyToOne
   @JoinColumn(name = "to_wallet")
   private WallletEntity toWallet;

   @Column(name = "transaction_value",nullable = false)
   private BigDecimal transactionValue;

   @Column(name = "status")
   @Enumerated(EnumType.STRING)
   private TransactionStatusEnum status;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
