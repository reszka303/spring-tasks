package pl.javastart.equipy.components.inventory.asset;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Wyposażenie z takim numerem seryjnym już istnieje")
public class DuplicateSerialNumberException extends RuntimeException {
}
