package pl.javastart.equipy.components.assignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Nie istnieje przypisanie o takim Id")
public class AssignmentNotFoundException extends RuntimeException {
}
