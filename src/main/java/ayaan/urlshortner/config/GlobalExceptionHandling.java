package ayaan.urlshortner.config;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(SQLException.class)
    public String sqlExceptionHandler(){
        return "Sql Exception Occurred";
    }

    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException ex) {
        return "Database connection failed";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return ex.getClass().getName();
    }
}
