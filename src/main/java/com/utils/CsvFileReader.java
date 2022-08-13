package com.utils;

import com.models.Product;
import com.service.ProductFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class CsvFileReader {


    public static int poistion = 0;
    public static final String HEADER_TYPE = "type";
    public static final String HEADER_SERIES = "series";
    public static final String HEADER_SCREEN_TYPE = "screen type";
    public static final String HEADER_PRICE = "price";
    public static final String HEADER_DIAGONAL = "diagonal";
    public static final String HEADER_MODEL = "model";

    public static final String HEADER_COUNTRY = "country";

    public static List<String> HEADERS = new LinkedList<>();



    public List<? extends Product> parseProduct() throws URISyntaxException, IOException, WrongCSVFileReadingException {
        List<? extends Product> products = new LinkedList<>();
        URL reader = this.getClass().getClassLoader().getResource("file.csv");
        try(Stream<String> br = Files.lines(Path.of(reader.toURI()))) {
            HEADERS = br.findFirst().map(CsvFileReader::readHeader).orElseThrow(() -> new WrongCSVFileReadingException("Missing header"));
        }

        try (Stream<String> br = Files.lines(Path.of(reader.toURI()))) {
            br.skip(1).map(x -> reader(x,HEADERS))
                    .filter(Objects::nonNull)
                    .forEach(map -> products.add(ProductFactory.createAndSave(map)));
        }
        return products;
    }

    private static List<String> readHeader(String line) {
        return List.of(line.split(","));

    }

    private static Map<String, String> reader(String line,List<String> headers) {
       Map<String, String> map = new HashMap<>();
        try {
            String[] words = line.split(",");
            int el = 0;
            for(String str : words) {
                if(str.isEmpty()) {
                    throw new WrongCSVFileReadingException("Can't read this line. " + headers.get(el) +
                            " at this column and at this line " + poistion +
                            " element is wrong, line won't be converted.");
                }
                map.put(headers.get(el),str);
                el++;
            }
            poistion++;
        }catch (WrongCSVFileReadingException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return map;
    }
}
