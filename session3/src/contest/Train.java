package contest;

import java.io.*;
import java.util.*;

public class Train {

    static Stack<Tuple> stack;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
        String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            int n = Integer.parseInt(reader.readLine());
            stack = new Stack<>();
            int value = 0;
            for (int i = 0; i < n; i++) {
                String[] str = reader.readLine().split(" ");
                switch (str[0]) {
                    case "add":
                        value = Integer.parseInt(str[1]);
                        stack.push(new Tuple(str[2], value));
                        map.merge(str[2], value, Integer::sum);
                        break;
                    case "delete":
                        value = Integer.parseInt(str[1]);
                        while (value > 0) {
                            if(stack.isEmpty()) break;
                            Tuple tuple = stack.back();
                            int newValue = 0;
                            if(value > tuple.value) {
                                stack.pop();
                                value -= tuple.value;
                                newValue = map.get(tuple.name) - tuple.value;
                            } else {
                                tuple.value -= value;
                                newValue = map.get(tuple.name) - value;
                                value = 0;
                            }
                            map.put(tuple.name, newValue);
                        }
                        break;
                    case "get":
                        String answer = (map.getOrDefault(str[1], 0)) + "\n";
                        writer.write(answer);
                }
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class Stack<T> {

        final String OK = "ok";
        List<T> values;

        String push(T value) {
            values.add(0, value);
            return OK;
        }

        T pop() {
            T value = values.get(0);
            values.remove(0);
            return value;
        }

        T back() {
            return values.get(0);
        }

        int size() {
            return values.size();
        }

        String clear() {
            values.clear();
            return OK;
        }

        boolean isEmpty() {
            return values.isEmpty();
        }

        public Stack() {
            this.values = new LinkedList<>();
        }
    }

    static class Tuple {
        String name;
        int value;

        public Tuple(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}
