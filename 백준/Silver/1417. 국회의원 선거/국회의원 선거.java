import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
    static int minValue;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        int N = Integer.parseInt(br.readLine());
        minValue = Integer.parseInt(br.readLine());
        while (N-- > 1) {
            que.add(Integer.parseInt(br.readLine()));
        }

        if(que.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }
    }

    static void process() {
        int cnt = 0;

        while (que.peek() >= minValue) {
            que.add(que.poll() - 1);
            minValue++;
            cnt++;
        }

        System.out.println(cnt);
    }
}