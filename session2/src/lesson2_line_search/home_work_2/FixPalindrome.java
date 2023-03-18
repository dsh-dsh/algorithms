package lesson2_line_search.home_work_2;

import java.io.*;

public class FixPalindrome {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            char[] input = reader.readLine().toCharArray();

            int result = getLettersNum(input);

            writer.write(String.valueOf(result));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int getLettersNum(char[] input) {
        if(input.length <= 1) return 0;
        int num = 0;
        int left = input.length / 2 - 1;
        int right = input.length / 2 + (input.length % 2);
        while(true) {
            if(input[left] != input[right]) num++;
            if(left == 0) break;
            left--;
            right++;
        }
        return num;
    }
}
