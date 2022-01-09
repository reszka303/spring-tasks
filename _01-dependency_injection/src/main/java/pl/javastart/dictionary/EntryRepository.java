package pl.javastart.dictionary;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EntryRepository {

    private List<Entry> entries;

    EntryRepository() {
        FileService fileService = new FileService();
        try {
            this.entries = fileService.readEntries();
        } catch (IOException e) {
            entries = new ArrayList<>();
        }
    }

    List<Entry> getEntries() {
        return entries;
    }

    void add(Entry entry) {
        entries.add(entry);
    }

    boolean isEmpty() {
        return entries.isEmpty();
    }
}
