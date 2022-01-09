package pl.javastart.dictionary.formatter;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class UpperCaseTextFormatter implements TextFormatter {

    @Override
    public String format(String originalText) {
        return originalText.toUpperCase();
    }

}
