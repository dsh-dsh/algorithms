package lesson4_map_count_sort.home_work;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class VoteCount {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {

//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
//             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {
//            Map<String, Integer> map = getVoices(reader);
//            map.keySet().stream().sorted()
//                    .forEach(s -> writer.write(s + " " + map.get(s)));
//            writer.write(result);
//            writer.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        printVoices();

    }

    private static void printVoices(Map<String, Integer> voices) {
        voices.keySet().stream().sorted()
                .forEach(s -> System.out.println(s + " " + voices.get(s)));
    }

    private static Map<String, Integer> getVoices(BufferedReader reader) throws IOException {
        Map<String, Integer> voices = new HashMap<>();
        while (reader.ready()) {
            String line = reader.readLine();
            if(line.equals("")) break;
            String[] arr = line.split(" ");
            String key = arr[0];
            int value = Integer.parseInt(arr[1]);
            voices.merge(key, value, Integer::sum);
        }
        return voices;
    }
}
