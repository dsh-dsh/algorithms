package lesson2_line_search.home_work_1;

import java.io.*;

public class Triangle {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            int d = Integer.parseInt(reader.readLine());
            String[] line = reader.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            int result = getResult(d, x, y);
            System.out.println(result);

            writer.write(String.valueOf(result));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int getResult(int d, int x, int y) {
        if(d == 0) return 0;
        int sing = d > 0 ? 1 : -1;
        x = x * sing;
        y = y * sing;
        d = d * sing;
        if((x >= 0 && y >= 0) && (x + y <= d)) return 0;

        Cort a = new Cort(hip(x, y), 1);
        Cort b = new Cort(hip(d-x, y), 2);
        Cort c = new Cort(hip(x, d-y), 3);

        return min(min(a, b), min(b, c)).num;
    }

    private static int hip(int x, int y) {
        return (int) Math.pow(x, 2) + (int) Math.pow(y, 2);
    }

    private static Cort min(Cort a, Cort b) {
        if(a.value <= b.value) return a;
        else return b;
    }

    private static class Cort{
        int value;
        int num;
        public Cort(int value, int num) {
            this.value = value;
            this.num = num;
        }
    }
}
