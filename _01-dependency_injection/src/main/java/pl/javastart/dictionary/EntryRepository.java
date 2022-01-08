package pl.javastart.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
