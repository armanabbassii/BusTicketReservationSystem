package ir.maktabsharif.busticketreservationsystem.dto.purchase;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PurchaseResponseDto(
        Long purchaseId,
        String purchaseNumber,
        Long userId,
        Long ticketId,
        Double pricePaid,
        Integer quantity,
        String gender,
        LocalDate purchaseTime
) {
}
