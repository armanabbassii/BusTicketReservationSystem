package ir.maktabsharif.busticketreservationsystem.dto;

import ir.maktabsharif.busticketreservationsystem.domain.enums.TICKET_TYPE;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
