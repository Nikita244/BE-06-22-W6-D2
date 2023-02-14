package it.epicode.be.prenotazioni.common.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.epicode.be.prenotazioni.exception.IstruzioniException;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GestionePrenotazioniExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IstruzioniException.class)
    protected ResponseEntity<Object> handleEpicodeException(IstruzioniException ex) {

        ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
