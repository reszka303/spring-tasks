package pl.javastart.equipy.components.inventory.asset;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak wyposażenia o takim Id")
public class AssetNotFoundException extends RuntimeException {
}
