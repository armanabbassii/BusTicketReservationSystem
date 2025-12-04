package ir.maktabsharif.busticketreservationsystem.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
@RestControllerAdvice
public class GlobalExceptionHandler {
// custom exception for entire local error
//
    private ExceptionResponse buildResponse(
            String message,
            HttpStatus status,
            HttpServletRequest request
    ) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(message);
        response.setPath(request.getRequestURI());
        response.setStatus(status.value());
        response.setTimestamp(Instant.now().toString());
        response.setError(status.getReasonPhrase());
        return response;
    }

    // 🔹 User exception
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponse> handleUserException(
            UserException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request));
    }

    // 🔹 Other general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGeneralException(
            Exception ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, request));
    }

    @ExceptionHandler(PurchaseException.class)
    public ResponseEntity<ExceptionResponse> handlePurchase(PurchaseException ex, HttpServletRequest request) {

        ExceptionResponse response = buildResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                request
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

