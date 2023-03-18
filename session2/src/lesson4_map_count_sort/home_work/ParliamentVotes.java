package lesson4_map_count_sort.home_work;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParliamentVotes {

    private static final String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
    private static final String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";
    private static final int ALL_PLACES = 450;
    private static double quotient;
    private static int allVotes;
    private static int busyPlaces;

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            List<Tuple> list = getVoteMap(reader);
            quotient = (double) allVotes / ALL_PLACES;
            countPlaces(list);
            List<Tuple> listCopy = new ArrayList<>(list);
            addPlaces(listCopy);
            String result = getResult(list);

            writer.write(result);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getResult(List<Tuple> list) {
        return list.stream()
                .map(Tuple::toString)
                .collect(Collectors.joining("\n"));
    }

    private static void addPlaces(List<Tuple> listCopy) {
        while (busyPlaces < ALL_PLACES) {
            Collections.sort(listCopy);
            for(Tuple tuple: listCopy) {
                if(busyPlaces == ALL_PLACES) break;
                tuple.places++;
                busyPlaces++;
            }
        }
    }

    private static void countPlaces(List<Tuple> list) {
        for(Tuple tuple : list) {
            int places = (int) (tuple.votes / quotient);
            tuple.places = (int) (tuple.votes / quotient);
            busyPlaces += places;
        }
    }

    private static List<Tuple> getVoteMap(BufferedReader reader) throws IOException {
        List<Tuple> list = new ArrayList<>();
        while (reader.ready()) {
            String str = reader.readLine();
            if(str.equals("")) break;
            String[] line = str.split(" ");
            String name = "";
            for (int i = 0; i < line.length - 1; i++) {
                name += line[i] + " ";
            }
            int votes = Integer.parseInt(line[line.length - 1]);
            list.add(new Tuple(name.trim(), votes));
            allVotes += votes;
        }
        return list;
    }

    static class Tuple implements Comparable<Tuple>{
        String name;
        int votes;
        int places;

        public Tuple(String name, int votes) {
            this.name = name;
            this.votes = votes;
        }

        @Override
        public String toString() {
            return name + " " + places;
        }

        @Override
        public int compareTo(Tuple o) {
            int i = Double.compare((double) o.votes / quotient - o.places, (double) this.votes / quotient - this.places);
            if(i == 0) return o.votes - this.votes;
            else return i;
        }
    }
}
