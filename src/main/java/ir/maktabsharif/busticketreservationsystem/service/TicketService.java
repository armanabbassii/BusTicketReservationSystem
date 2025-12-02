package ir.maktabsharif.busticketreservationsystem.service;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Ticket;
import ir.maktabsharif.busticketreservationsystem.dto.AddTicketDto;

import java.util.List;

public interface TicketService {
    Ticket addTicket(Long companyId, AddTicketDto dto);
    List<Ticket> getTicketByCompany(Long companyId);
    Ticket getTicketById(Long ticketId);
}
