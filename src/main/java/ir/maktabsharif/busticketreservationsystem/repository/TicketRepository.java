package ir.maktabsharif.busticketreservationsystem.repository;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Ticket;
import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.domain.enums.TICKET_TYPE;
import ir.maktabsharif.busticketreservationsystem.dto.ticket.SearchTicketDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCompany(User company);

//    List<Ticket> findByDepartureCityAndDestinationCityAndArrivalTimeOrderByArrivalTime(
//            String departureCity, String destinationCity, LocalDate arrivalTime);
    List<Ticket> findByDepartureCityAndDestinationCityAndArrivalTime(
            String departureCity, String destinationCity, LocalDate arrivalTime);

    List<Ticket> findByTicketType(TICKET_TYPE ticketType);
}
