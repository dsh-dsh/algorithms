package lesson2_line_search.home_work_2;

import java.io.*;

public class Folders {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            int num = Integer.parseInt(reader.readLine());
            String[] secondLine = reader.readLine().split(" ");
            int[] folders = new int[secondLine.length];
            for (int i = 0; i < secondLine.length; i++) {
                folders[i] = Integer.parseInt(secondLine[i]);
            }

            int result = showRest(folders);

            writer.write(String.valueOf(result));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int showRest(int[] folders) {
        int max = 0;
        int result = 0;
        for (int i = 0; i < folders.length; i++) {
            max = Math.max(max, folders[i]);
            result += folders[i];
        }
        return result - max;
    }
}
