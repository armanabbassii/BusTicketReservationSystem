package ir.maktabsharif.busticketreservationsystem.mapper;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Purchase;
import ir.maktabsharif.busticketreservationsystem.dto.purchase.PurchaseResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {
    public PurchaseResponseDto toDto(Purchase purchase) {
        return new PurchaseResponseDto(
                purchase.getPurchaseId(),
                purchase.getPurchaseNumber(),
                purchase.getUser().getUserId(),
                purchase.getTicket().getTicketId(),
                purchase.getPricePaid(),
                purchase.getQuantity(),
                purchase.getGender(),
                purchase.getPurchaseTime()
        );
    }
}
