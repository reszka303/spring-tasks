package pl.javastart.dictionary.formatter;

import org.springframework.stereotype.Component;

@Component
public class BasicTextFormatter implements TextFormatter {

    @Override
    public String format(String originalText) {
        return originalText;
    }

}
