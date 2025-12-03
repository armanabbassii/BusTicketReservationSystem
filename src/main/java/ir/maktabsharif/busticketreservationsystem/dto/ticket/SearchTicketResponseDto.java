package ir.maktabsharif.busticketreservationsystem.dto.ticket;

import java.time.LocalDate;

public record SearchTicketResponseDto(
         Long ticketId,
        String departureCity,
        String destinationCity,
        LocalDate arrivalTime
) {
}
