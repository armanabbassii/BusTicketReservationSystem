package ir.maktabsharif.busticketreservationsystem.dto.ticket;

import ir.maktabsharif.busticketreservationsystem.domain.enums.TICKET_TYPE;

import java.time.LocalDate;

public record AddTicketDto(String ticketNumber,
                           String departureCity,
                           String destinationCity,
                           LocalDate departureTime,
                           LocalDate arrivalTime,
                           Double price,
                           Integer totalSeats,
                           Integer availableSeats,
                           TICKET_TYPE ticketType) {
}
