package com.utils;

import com.models.ProductType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class CsvFileReader {

    static List<String> HEADERS = new ArrayList<>();
    static List<HashMap<String, Object>> fileReader = new ArrayList<>();

    public List<HashMap<String, Object>> parseProduct() throws URISyntaxException, IOException {
        URL reader = this.getClass().getClassLoader().getResource("file.csv");
        try (Stream<String> br = Files.lines(Path.of(reader.toURI()))) {
            br.limit(1).forEach(CsvFileReader::read);
        }
        try (Stream<String> br = Files.lines(Path.of(reader.toURI()))) {
            br.skip(1).forEach(CsvFileReader::reader);
        }
        return fileReader;
    }

    public static String read(String line) {
        String str = "";
        int ind = 0;
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == 59) {
                str = line.substring(ind, i).trim();
                ind = i + 1;
                HEADERS.add(str);
            }
            i++;
        }
        HEADERS.add(line.substring(ind));
        return str;
    }

    public static void reader(String line) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            String str = "";
            int ind = 0;
            int el = 0;
            int i = 0;
            while (i < line.length()) {
                if (line.charAt(i) == 59) {
                    str = line.substring(ind, i).trim();
                    if(str.isEmpty()) {
                        throw new WrongCSVFileReadingException("Can't read this line. " +
                                HEADERS.get(el) + " at this column and at this line " +
                                fileReader.size() + " element is wrong, line won't be converted.");
                    }
                    ind = i + 1;
                    if (Objects.equals(HEADERS.get(el), "type")) {
                        if (str.equals("Telephone")) {
                            map.put(HEADERS.get(el), ProductType.TELEPHONE);
                        } else {
                            map.put(HEADERS.get(el), ProductType.TELEVISION);
                        }
                        el++;
                        i++;
                        continue;
                    }
                    map.put(HEADERS.get(el), str);
                    el++;
                }
                i++;
            }
            map.put(HEADERS.get(el), Double.parseDouble(line.substring(ind)));
            fileReader.add(map);
        }catch (WrongCSVFileReadingException e) {
            System.out.println(e.getMessage());
        }
    }
}
