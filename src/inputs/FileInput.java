package inputs;
import adresses.Address;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileInput {
    public static Map<Address, Integer> loadFromCSV(String filename) throws IOException {
        Map<Address, Integer> map = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String country = parts[0].trim();
                String city = parts[1].trim();
                int cost = Integer.parseInt(parts[2].trim());
                map.put(new Address(country, city), cost);
            }
        }
        return map;
    }

}