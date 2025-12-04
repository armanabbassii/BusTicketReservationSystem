package ir.maktabsharif.busticketreservationsystem.service;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Purchase;

import java.util.List;

public interface PurchaseService extends BaseService<Purchase, Long>{

    Purchase purchaseTicket(Long userId, Long ticketId, int quantity, String gender);
    List<Purchase> getPurchaseOfUser(Long userId);
    void cancelPurchase(Long purchaseId);
}
