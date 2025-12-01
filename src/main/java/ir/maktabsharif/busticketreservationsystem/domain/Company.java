//package ir.maktabsharif.busticketreservationsystem.domain;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Builder
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Company {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long companyId;
//    private String username;
//    private String password;
//    private String email;
//    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    List<Ticket> ticketList = new ArrayList<>();
//}
