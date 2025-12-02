package ir.maktabsharif.busticketreservationsystem.domain.entity;

import ir.maktabsharif.busticketreservationsystem.domain.enums.USER_ROLE;
import ir.maktabsharif.busticketreservationsystem.domain.enums.USER_STATUS;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private USER_ROLE userRole;
    @Enumerated(EnumType.STRING)
    private USER_STATUS userStatus;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Purchase> purchaseList = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    List<Ticket> ticketList = new ArrayList<>();
}

