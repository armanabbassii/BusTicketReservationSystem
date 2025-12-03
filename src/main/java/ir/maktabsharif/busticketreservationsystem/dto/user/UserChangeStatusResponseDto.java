package ir.maktabsharif.busticketreservationsystem.dto.user;

public record UserChangeStatusResponseDto(long userId, String username,String user_role, String user_status) {
}
