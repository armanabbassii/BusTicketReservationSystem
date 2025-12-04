package ir.maktabsharif.busticketreservationsystem.service.impl;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Purchase;
import ir.maktabsharif.busticketreservationsystem.domain.entity.Ticket;
import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.exception.PurchaseException;
import ir.maktabsharif.busticketreservationsystem.exception.UserException;
import ir.maktabsharif.busticketreservationsystem.repository.PurchaseRepository;
import ir.maktabsharif.busticketreservationsystem.repository.TicketRepository;
import ir.maktabsharif.busticketreservationsystem.repository.UserRepository;
import ir.maktabsharif.busticketreservationsystem.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    @Override
    public void cancelPurchase(Long purchaseId) {
        Purchase purchase = purchaseRepository.findByPurchaseId(purchaseId)
                .orElseThrow(() -> new PurchaseException("purchase not found"));
        Ticket ticket = purchase.getTicket();
        ticket.setAvailableSeats(ticket.getAvailableSeats() + purchase.getQuantity());
        ticketRepository.save(ticket);
        purchaseRepository.delete(purchase);
    }

    @Override
    public Purchase purchaseTicket(Long userId, Long ticketId, int quantity, String gender) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("user not found"));
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("flight not found"));
        if (ticket.getAvailableSeats() < quantity) {
            throw new PurchaseException("not enough seats available");
        }

        ticket.setAvailableSeats(ticket.getAvailableSeats() - quantity);

        Purchase purchase = Purchase.builder()
                .purchaseNumber(UUID.randomUUID().toString())
                .purchaseTime(LocalDate.now())
                .pricePaid(ticket.getPrice() * quantity)
                .quantity(quantity)
                .gender(gender)
                .user(user)
                .ticket(ticket)
                .build();

        return purchaseRepository.save(purchase);
    }


    @Override
    public List<Purchase> getPurchaseOfUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("user not found"));
        return purchaseRepository.findByUser_UserId(userId);
    }

    @Override
    public Purchase save(Purchase entity) {
        return null;
    }

    @Override
    public Optional<Purchase> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Purchase> findAll() {
        return List.of();
    }

    @Override
    public Purchase update(Purchase entity, Long aLong) {
        return null;
    }
}
