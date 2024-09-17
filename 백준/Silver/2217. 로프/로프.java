import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Integer[] roap;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        roap = new Integer[N];

        for (int i = 0; i < N; i++)
            roap[i] = Integer.parseInt(br.readLine());

    }

    static void process() {
        Arrays.sort(roap, Collections.reverseOrder());
        int total = 0;

        for (int i = 0; i < N; i++)
            total = Math.max(total, roap[i] * (i + 1));

        System.out.println(total);
    }
}