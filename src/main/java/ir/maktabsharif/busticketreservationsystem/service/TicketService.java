package ir.maktabsharif.busticketreservationsystem.service;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Ticket;
import ir.maktabsharif.busticketreservationsystem.domain.enums.TICKET_TYPE;
import ir.maktabsharif.busticketreservationsystem.dto.ticket.AddTicketDto;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {
    Ticket addTicket(Long companyId, AddTicketDto dto);
    List<Ticket> getTicketByCompany(Long companyId);
    Ticket getTicketById(Long ticketId);
    List<Ticket> getTicketList (String departureCity, String destinationCity, LocalDate arrivalTime);
    List<Ticket> findByTicketType(TICKET_TYPE ticketType);


}
