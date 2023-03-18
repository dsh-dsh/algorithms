package lesson2_line_search.home_work_2;

import java.io.*;

public class Benches {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            String[] firstLine = reader.readLine().split(" ");
            int length = Integer.parseInt(firstLine[0]);
            String[] secondLine = reader.readLine().split(" ");
            int[] legs = new int[secondLine.length];
            for (int i = 0; i < secondLine.length; i++) {
                legs[i] = Integer.parseInt(secondLine[i]);
            }

            String result = showRest(length, legs);

            writer.write(result);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String showRest(int length, int[] legs) {
        int leftLeg = -1;
        int rightLeg = -1;
        for (int i = 0; i < legs.length; i++) {
            if(length - legs[i] * 2  == 1) {
                return String.valueOf(legs[i]);
            }
            if(legs[i] * 2 < length) {
                leftLeg = legs[i];
            }
            if(legs[i] * 2 >= length) {
                rightLeg = legs[i];
                break;
            }
        }
        return leftLeg + " " + rightLeg;
    }
}
