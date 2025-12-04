package ir.maktabsharif.busticketreservationsystem.dto.purchase;

public record PurchaseRequestDto(
        Long userId,
        Long ticketId,
        int quantity,
        String gender
) {
}
