package pl.javastart.equipy.components.assignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "To przypisanie zostało już zakończone")
public class AssignmentAlreadyFinishedException extends RuntimeException {
}
