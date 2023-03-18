package lesson2_line_search.home_work_1;

import java.io.*;

public class School {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            int pupils = Integer.parseInt(reader.readLine());
            String[] line = reader.readLine().split(" ");
            int[] houses = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                houses[i] = Integer.parseInt(line[i]);
            }

            int result = getResult(pupils, houses);

            writer.write(String.valueOf(result));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getResult(int num, int[] arr) {
        int pointer = num / 2;
        return arr[pointer];
    }
}
