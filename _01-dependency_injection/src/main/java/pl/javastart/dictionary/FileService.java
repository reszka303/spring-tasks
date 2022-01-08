package pl.javastart.dictionary;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {

    private final String fileName = "D:\\INNE\\Programowanie\\Projects\\spring-tasks" +
            "\\_01-dependency_injection\\src\\main\\resources\\static\\data.csv";

    List<Entry> readEntries() throws IOException {
        List<Entry> entries;
        var reader = new BufferedReader(new FileReader(fileName));
            entries = reader.lines()
                    .map(CsvEntryConverter::parse)
                    .collect(Collectors.toList());
        return entries;
    }

//    List<Entry> readEntries() {
//        List<Entry> entries;
//        try (var reader = new BufferedReader(new FileReader(fileName))) {
//            entries = reader.lines()
//                    .map(CsvEntryConverter::parse)
//                    .collect(Collectors.toList());
//        } catch (FileNotFoundException e) {
//            throw new DataReadException("No file " + fileName);
//        } catch (IOException e) {
//            throw new DataReadException("Error read file" + fileName);
//        }
//        return entries;
//    }

    void writeEntries(List<Entry> entries) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Entry entry : entries) {
            writer.write(entry.toString());
        }
        writer.close();
    }

//    void writeEntries(List<Entry> entries) {
//        try (var writer = new BufferedWriter(new FileWriter(fileName))) {
//            for (Entry entry : entries) {
//                writer.write(entry.toString());
//            }
//        } catch (IOException e) {
//            throw new DataWriteException("Data write error into file " + fileName);
//        }
//    }


    private static class CsvEntryConverter {

        private static Entry parse(String text) {
            String[] split = text.split(";");
            return new Entry(split[0], split[0]);
        }
    }


}
