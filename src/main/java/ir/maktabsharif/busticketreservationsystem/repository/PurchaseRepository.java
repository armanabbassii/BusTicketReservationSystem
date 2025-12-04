package ir.maktabsharif.busticketreservationsystem.repository;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    List<Purchase> findByUser_UserId(Long userId);
    Optional<Purchase> findByPurchaseId(Long purchaseId);

}
