package ir.maktabsharif.busticketreservationsystem.controller;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Purchase;
import ir.maktabsharif.busticketreservationsystem.dto.purchase.PurchaseRequestDto;
import ir.maktabsharif.busticketreservationsystem.dto.purchase.PurchaseResponseDto;
import ir.maktabsharif.busticketreservationsystem.mapper.PurchaseMapper;
import ir.maktabsharif.busticketreservationsystem.service.PurchaseService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final PurchaseMapper purchaseMapper;

    @PostMapping("/users/purchaseTicket")
    public ResponseEntity<PurchaseResponseDto> purchaseTicket(
            @RequestBody PurchaseRequestDto dto
    ) {
        Purchase purchase = purchaseService.purchaseTicket(
                dto.userId(), dto.ticketId(), dto.quantity(), dto.gender()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(purchaseMapper.toDto(purchase));
    }

    @GetMapping("/users/{userId}/purchase")
    public ResponseEntity<List<PurchaseResponseDto>> getUserPurchases(
            @PathVariable Long userId
    ) {
        List<Purchase> purchases = purchaseService.getPurchaseOfUser(userId);
        return ResponseEntity.ok(
                purchases.stream()
                        .map(purchaseMapper::toDto)
                        .toList()
        );
    }

    @DeleteMapping("/purchase/{id}")
    public ResponseEntity<?> cancelPurchase(@PathVariable Long id) {
        purchaseService.cancelPurchase(id);
        return ResponseEntity.ok("Purchase canceled successfully");
    }
}
