package ir.maktabsharif.busticketreservationsystem.controller;

import ir.maktabsharif.busticketreservationsystem.domain.entity.Ticket;
import ir.maktabsharif.busticketreservationsystem.domain.enums.TICKET_TYPE;
import ir.maktabsharif.busticketreservationsystem.dto.ticket.AddTicketDto;
import ir.maktabsharif.busticketreservationsystem.dto.ticket.TicketResponseDto;
import ir.maktabsharif.busticketreservationsystem.mapper.TicketMapper;
import ir.maktabsharif.busticketreservationsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketMapper ticketMapper;
    private final TicketService ticketService;

    @PostMapping("/{companyId}/add")
    public ResponseEntity<TicketResponseDto> addTicket(
            @PathVariable Long companyId,
            @RequestBody AddTicketDto addTicketDto
    ) {
        Ticket ticket = ticketService.addTicket(companyId, addTicketDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketMapper.toDto(ticket));
    }


    @GetMapping("/{companyId}/list")
    public ResponseEntity<List<TicketResponseDto>> getTicketListByCompany(
            @PathVariable Long companyId
    ) {
        List<Ticket> ticketList = ticketService.getTicketByCompany(companyId);
        List<TicketResponseDto> response = ticketMapper.toDtoList(ticketList);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable Long ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticketMapper.toDto(ticket));
    }

    @GetMapping("/ticketList")
    public ResponseEntity<List<TicketResponseDto>> ticketList(
            @RequestParam String departureCity,
            @RequestParam String destinationCity,
            @RequestParam LocalDate arrivalTime) {
        List<Ticket> tickets = ticketService.getTicketList(departureCity, destinationCity, arrivalTime);
        return ResponseEntity.ok(ticketMapper.toDtoList(tickets));
    }

    @GetMapping("/ticketType")
    public ResponseEntity<List<TicketResponseDto>> searchByType(
            @RequestParam TICKET_TYPE ticketType) {
        List<Ticket> tickets = ticketService.findByTicketType(ticketType);
        return ResponseEntity.ok(ticketMapper.toDtoList(tickets));
    }

}
