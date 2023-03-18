package lesson2_line_search.home_work_2;

import java.io.*;

public class MaxDist {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            String[] input = reader.readLine().split(" ");
            int[] houses = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                houses[i] = Integer.parseInt(input[i]);
            }

            int result = getResult(houses);

            System.out.println(result);

            writer.write(String.valueOf(result));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int getResult(int[] houses) {
        int max = 0;
        int distForward = 0;
        int distBackward = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == 1) {
                distForward = distBackward = 0;
                left = right = i;
                while(true) {
                    if(houses[left] == 2) {
                        if(max < distBackward) max = distBackward;
                        break;
                    }
                    if(houses[right] == 2) {
                        if(max < distForward) max = distForward;
                        break;
                    }
                    if(left > 0) {
                        left--;
                        distBackward++;
                    }
                    if(right < houses.length - 1) {
                        right++;
                        distForward++;
                    }
                }
            }
        }
        return max;
    }

}
