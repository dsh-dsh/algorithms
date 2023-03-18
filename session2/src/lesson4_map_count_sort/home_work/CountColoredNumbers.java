package lesson4_map_count_sort.home_work;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CountColoredNumbers {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            List<Integer> list = new ArrayList<>();
            Map<Integer, Long> map = new HashMap<>();

            setValues(reader, list, map);
            Collections.sort(list);

            String result = list.stream()
                    .sorted()
                    .map(i -> i + " " + map.get(i))
                    .collect(Collectors.joining("\n"));

            writer.write(result);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setValues(BufferedReader reader, List<Integer> list, Map<Integer, Long> map) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] values = line.split(" ");
            int key = Integer.parseInt(values[0]);
            long value = Long.parseLong(values[1]);
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
                list.add(key);
            }
        }
    }
}
