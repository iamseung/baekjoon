import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static int N;
    static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            queue.offer(Integer.parseInt(br.readLine()));
        }
    }

    static void process() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!queue.isEmpty()) {
            bw.write(Integer.toString(queue.poll()));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}