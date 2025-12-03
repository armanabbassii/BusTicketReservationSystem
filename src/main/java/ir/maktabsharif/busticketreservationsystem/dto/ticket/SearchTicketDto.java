package ir.maktabsharif.busticketreservationsystem.dto.ticket;

import java.time.LocalDate;

public record SearchTicketDto(String departureCity, String destinationCity, LocalDate departureTime) {
}
