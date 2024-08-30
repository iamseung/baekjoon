import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Long> list = new ArrayList<>();
    static int N;
    static int CNT = 0;
    static final int LIMIT = 10;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        if (N <= LIMIT) {
            System.out.println(N);
            return;
        }

        /*
         * 자리마다 0 -9, 10개의 수를 활용
         * 9,876,543,210 이 제일 큰 수
         * 즉 2 ^ 10 - 1 까지가 감소하는 수의 범위
         */
        if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < LIMIT; i++) {
            backTracking(1, i);
        }
        Collections.sort(list);
        System.out.println(list.get(N));

    }

    static void backTracking(int idx, long cur) {
        // 10 자리가 MAX
        if (idx > 10)
            return;

        list.add(cur);

        for (int i = 0; i < cur % 10; i++) {
            backTracking(idx + 1, cur * 10 + i);
        }

    }
}