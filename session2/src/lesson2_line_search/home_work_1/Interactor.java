package lesson2_line_search.home_work_1;

import java.io.*;

public class Interactor {

    private static String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))){

            int code = Integer.parseInt(reader.readLine());
            int interactor = Integer.parseInt(reader.readLine());
            int checker = Integer.parseInt(reader.readLine());
            int result = 0;

//            System.out.println(code + " " + interactor + " " + checker);

            switch (interactor) {
                case 7:
                    result = 1;
                    break;
                case 6:
                    result = 0;
                    break;
                case 4:
                    result = extracted(code, interactor);
                    break;
                case 1:
                    result = checker;
                    break;
                case 0:
                    result = extracted(code, checker);
                    break;
                default:
                    result = interactor;
                    break;
            }

//            System.out.println(result);

            writer.write(String.valueOf(result));
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private static int extracted(int code, int value) {
        int result;
        if (code != 0) {
            return  3;
        } else {
            return value;
        }
    }

}


