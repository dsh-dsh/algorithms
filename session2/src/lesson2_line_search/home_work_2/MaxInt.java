package lesson2_line_search.home_work_2;

import java.io.*;

public class MaxInt {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            int i;
            int max = 0;
            int count = 0;
            while (true) {
                i = Integer.parseInt(reader.readLine());
                if (i == 0) break;
                if(i > max) {
                    max = i;
                    count = 1;
                } else if(max == i) {
                    count++;
                }
            }

            System.out.println(count);

            writer.write(String.valueOf(count));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
