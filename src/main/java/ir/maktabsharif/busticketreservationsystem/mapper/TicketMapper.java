package ir.maktabsharif.busticketreservationsystem.mapper;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Ticket;
import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.AddTicketDto;
import ir.maktabsharif.busticketreservationsystem.dto.TicketResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketMapper {
    public Ticket toEntity(AddTicketDto dto, User company) {
        return Ticket.builder()
                .ticketNumber(dto.ticketNumber())
                .departureCity(dto.departureCity())
                .destinationCity(dto.destinationCity())
                .departureTime(dto.departureTime())
                .arrivalTime(dto.arrivalTime())
                .price(dto.price())
                .totalSeats(dto.totalSeats())
                .availableSeats(dto.totalSeats())
                .ticketType(dto.ticketType())
                .company(company)
                .build();
    }

    public TicketResponseDto toDto(Ticket ticket) {
        return new TicketResponseDto(
                ticket.getTicketId(),
                ticket.getTicketNumber(),
                ticket.getDepartureCity(),
                ticket.getDestinationCity(),
                ticket.getDepartureTime(),
                ticket.getArrivalTime(),
                ticket.getPrice(),
                ticket.getTotalSeats(),
                ticket.getAvailableSeats(),
                ticket.getTicketType()
        );
    }
    public List<TicketResponseDto> toDtoList(List<Ticket> ticketList) {
        return ticketList.stream().map(this::toDto).toList();
    }
}
