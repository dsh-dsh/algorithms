package contest;

import java.io.*;

public class Leonid {

    private static final int[][] steps = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static int h, w;
    static Point[][] board;
    static char[][] aaa;

    public static void main(String[] args) {

        String inputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/input.txt";
        String outputFileName = "C:/Users/Daniil/Documents/IdeaProjects/Algoritms/resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)))) {

            String[] str = reader.readLine().split(" ");
            h = Integer.parseInt(str[0]);
            w = Integer.parseInt(str[1]);

            board = new Point[h][w];
            aaa = new char[h][w];
            for (int i = h - 1; i >= 0; i--) {
                String s = reader.readLine();
                for (int j = 0; j < w; j++) {
                    int a = s.charAt(j) == 'X' ? -2 : -1;
                    board[i][j] = new Point(a, 0);
                    aaa[i][j] = s.charAt(j);
                }
            }
            str = reader.readLine().split(" ");
            int sx = Integer.parseInt(str[1]) - 1;
            int sy = Integer.parseInt(str[0]) - 1;
            str = reader.readLine().split(" ");
            int tx = Integer.parseInt(str[1]) - 1;
            int ty = Integer.parseInt(str[0]) - 1;

            board[sx][sy] = new Point(0, 0);
            RingBufferQueue queue = new RingBufferQueue(h*w);
            Tuple t = new Tuple(sx, sy);
            queue.push(t);
            int x, y, weight, direction;
            while (!queue.isEmpty()) {
                Tuple next = queue.poll();
                Point nextPoint = board[next.x][next.y];
                for (int i = 0; i < 8; i++) {
                    x = next.x + steps[i][0];
                    y = next.y + steps[i][1];

                    if(next.y == y && next.x != x) direction = 1;
                    else if(next.x == x && next.y != y) direction = 2;
                    else if((next.x > x && next.y > x) || (next.x < x && next.y < y)) direction = 3;
                    else direction = 4;
                    if(nextPoint.direction != direction) weight = nextPoint.weight + 1;
                    else weight = nextPoint.weight;

                    step(weight, direction, x, y, queue);
                }
            }

            int answer = board[tx][ty].weight;
            writer.write(String.valueOf(answer));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void step(int weight, int direction, int x, int y, RingBufferQueue queue) {
        if(x < 0 || x >= h) return;
        if(y < 0 || y >= w) return;
        if(board[x][y].weight == -1) {
            board[x][y] = new Point(weight, direction);
            aaa[x][y] = Character.forDigit(weight, 10);
            queue.push(new Tuple(x, y));
        }
    }

    static class RingBufferQueue {
        Tuple[] queue;
        int head;
        int tail;
        int capacity;
        int size;

        public RingBufferQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new Tuple[capacity];
            head = tail = size = 0;
        }

        public void push(Tuple element) {
            if(size > capacity - 2) reorder();
            queue[tail % capacity] = element;
            tail++;
            size++;
        }

        public Tuple poll() {
            if (isEmpty()) return null;
            Tuple element = queue[head % capacity];
            queue[head % capacity] = null;
            head++;
            size--;
            return element;
        }

        private void reorder() {
            int h = head % capacity;
            int newCapacity = (int) (capacity * 1.5);
            Tuple[] newQueue = new Tuple[newCapacity];
            int rightLength = capacity - h;
            System.arraycopy(queue, h, newQueue, 0, rightLength);
            if(size > rightLength)
                System.arraycopy(queue, 0, newQueue, rightLength, size - rightLength);
            queue = newQueue;
            capacity = newCapacity;
            tail = size;
            head = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    static class Tuple {
        int x, y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Point {
        int weight, direction;

        public Point(int weight, int direction) {
            this.weight = weight;
            this.direction = direction;
        }
    }
}
