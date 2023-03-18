package lesson2_line_search.home_work_1;

import java.io.*;

public class Metro {

    private static String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            String[] line = reader.readLine().split(" ");
            int length = Integer.parseInt(line[0]);
            int start = Integer.parseInt(line[1]);
            int stop = Integer.parseInt(line[2]);

            int result = getResult(length, start, stop);

            writer.write(String.valueOf(result));
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static int getResult(int length, int start, int stop) {
        if(length == 0 || length == 1) return 0;
        int forward = Math.abs(stop - start) - 1;
        int backward = length - (forward + 2);
        return Math.min(forward, backward);
    }
}
