package pl.javastart.dictionary.crypto;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class CaesarCipherService implements CipherService {

    private static final int SHIFT = 3;

    @Override
    public String encrypt(String text) {
        return text.chars()
                .map(CaesarCipherService::shift)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    public String decrypt(String cipher) {
        return cipher.chars()
                .map(CaesarCipherService::shiftBack)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static int shift(int unicode) {
        return unicode + SHIFT;
    }

    private static int shiftBack(int unicode) {
        return unicode - SHIFT;
    }

}
