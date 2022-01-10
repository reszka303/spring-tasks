package pl.javastart.dictionary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

//    private final String fileName = "D:\\INNE\\Programowanie\\Projects\\spring-tasks" +
//            "\\_01-dependency_injection\\src\\main\\resources\\static\\data.csv";

    private final String fileName;

    FileService(@Value("${filename}") String fileName) {
        this.fileName = fileName;
    }

    List<Entry> readEntries() throws IOException {
        List<Entry> entries;
        var reader = new BufferedReader(new FileReader(fileName));
            entries = reader.lines()
                    .map(CsvEntryConverter::parse)
                    .collect(Collectors.toList());
        return entries;
    }

    void writeEntries(List<Entry> entries) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Entry entry : entries) {
            writer.write(entry.toCsv());
        }
        writer.close();
    }

    private static class CsvEntryConverter {

        private static Entry parse(String text) {
            String[] split = text.split(";");
            return new Entry(split[0], split[1]);
        }

    }

}
