package lesson4_map_count_sort.home_work;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintEntries {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            Map<String, Integer> map = getValuesMap(reader);
            String result = getResultString(map);

            writer.write(result);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getResultString(Map<String, Integer> map) {
        return map.entrySet().stream()
                .map(entry -> new Cort(entry.getKey(), entry.getValue()))
                .sorted()
                .map(cort -> String.valueOf(cort.value))
                .collect(Collectors.joining("\n"));
    }

    private static Map<String, Integer> getValuesMap(BufferedReader reader) {
        String str = reader.lines().collect(Collectors.joining(" "));
        str = str.replaceAll("  ", " ");
        Map<String, Integer> map = new HashMap<>();
        for(String s : str.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }
        return map;
    }

    static class Cort implements Comparable<Cort>{

        String value;
        int count;

        public Cort(String value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Cort o) {
            int v = o.count - this.count;
            if(v == 0) {
                return this.value.compareTo(o.value);
            } else {
                return v;
            }
        }
    }
}
