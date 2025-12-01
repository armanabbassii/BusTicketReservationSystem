package ir.maktabsharif.busticketreservationsystem.domain.entity;

import ir.maktabsharif.busticketreservationsystem.domain.enums.TICKET_TYPE;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ticketId;
    private String ticketNumber;
    private Double price;
    private String departureCity;
    private String destinationCity;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    private Integer totalSeats;
    private Integer availableSeats;

    @Enumerated
    private TICKET_TYPE ticketType;
    //    BUS,TRAIN,AIRPLANE
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private User company;

}
