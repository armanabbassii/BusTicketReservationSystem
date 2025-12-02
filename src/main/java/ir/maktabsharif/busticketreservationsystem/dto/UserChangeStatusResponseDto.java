package ir.maktabsharif.busticketreservationsystem.dto;

public record UserChangeStatusResponseDto(long userId, String username,String user_role, String user_status) {
}
