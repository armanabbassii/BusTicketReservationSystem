package ir.maktabsharif.busticketreservationsystem.repository;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

}
