package ir.maktabsharif.busticketreservationsystem.domain.entity;

import ir.maktabsharif.busticketreservationsystem.domain.enums.PURCHASE_STATUS;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long purchaseId;
    private String purchaseNumber;
    private LocalDateTime purchaseTime;
    private Double pricePaid;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private PURCHASE_STATUS purchaseStatus;
    // NEW,PENDING,DONE,CANCELED
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
// many seats from one ticket
}
