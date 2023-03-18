package lesson4_map_count_sort.home_work;

import java.io.*;
import java.util.*;

public class Forum {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            List<Tuple> topics = new ArrayList<>();
            Map<Integer, Integer> messages = new HashMap<>();

            setTopics(reader, topics, messages);
            setCounts(topics, messages);

            Collections.sort(topics);
            String result = topics.get(0).name;

            writer.write(result);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void setCounts(List<Tuple> topics, Map<Integer, Integer> messages) {
        for(Tuple topic : topics) {
            for(Map.Entry<Integer, Integer> entry : messages.entrySet()) {
                if(entry.getValue() == topic.number) topic.count++;
            }
        }
    }

    private static void setTopics(BufferedReader reader, List<Tuple> topics, Map<Integer, Integer> messages) throws IOException {
        int messageNum = Integer.parseInt(reader.readLine());
        int topicNumber = 0;
        for (int i = 1; i <= messageNum; i++) {
            int number = Integer.parseInt(reader.readLine());
            if(number == 0) {
                String name = reader.readLine();
                topics.add(new Tuple(name, ++topicNumber));
                messages.put(i, topicNumber);
            } else {
                messages.put(i, messages.get(number));
            }
            String body = reader.readLine();
        }
    }

    static class Tuple implements Comparable<Tuple> {
        String name;
        int number;
        int count;

        public Tuple(String name, int number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public int compareTo(Tuple o) {
            int a = Integer.compare(o.count, this.count);
            return a == 0 ? Integer.compare(o.number, this.number) : a;
        }
    }
}
