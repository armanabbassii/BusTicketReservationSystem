package ir.maktabsharif.busticketreservationsystem.service.impl;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Ticket;
import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.domain.enums.TICKET_TYPE;
import ir.maktabsharif.busticketreservationsystem.domain.enums.USER_ROLE;
import ir.maktabsharif.busticketreservationsystem.dto.ticket.AddTicketDto;
import ir.maktabsharif.busticketreservationsystem.exception.UserException;
import ir.maktabsharif.busticketreservationsystem.mapper.TicketMapper;
import ir.maktabsharif.busticketreservationsystem.repository.TicketRepository;
import ir.maktabsharif.busticketreservationsystem.repository.UserRepository;
import ir.maktabsharif.busticketreservationsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TicketMapper ticketMapper;

    @Override
    public Ticket addTicket(Long companyId, AddTicketDto dto) {
        User company = userRepository.findById(companyId)
                .orElseThrow(() -> new UserException("company not found"));

        if(!company.getUserRole().equals(USER_ROLE.COMPANY_ROLE)){
            throw new UserException("only company users can add tickets");
        }
        Ticket ticket = ticketMapper.toEntity(dto, company);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getTicketByCompany(Long companyId) {
        User company = userRepository.findById(companyId)
                .orElseThrow(() -> new UserException("company not found"));
        return ticketRepository.findByCompany(company);
    }

    @Override
    public Ticket getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("ticket not found"));
    }

    @Override
    public List<Ticket> getTicketList(String departureCity, String destinationCity, LocalDate arrivalTime) {
        return ticketRepository.findByDepartureCityAndDestinationCityAndArrivalTime(departureCity,destinationCity,arrivalTime);
    }

    @Override
    public List<Ticket> findByTicketType(TICKET_TYPE ticketType) {
        return ticketRepository.findByTicketType(ticketType);
    }
}
