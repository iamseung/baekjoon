import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K, B;
    static int[] arr;
    static boolean[] fix;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 연속한 K개의 신호등이 존재하도록
        B = Integer.parseInt(st.nextToken()); // 고장난 신호등 수
        arr = new int[N];
        fix = new boolean[N];

        while (B-- > 0)
            fix[Integer.parseInt(br.readLine()) - 1] = true;
    }

    static void process() {
        int min = K;
        int toFix = 0;

        for (int i = 0; i < K; i++) {
            // 고장난 신호등
            if (fix[i])
                toFix++;
        }

        min = Math.min(min, toFix);

        int start = 0;
        for (int i = K; i < N; i++) {
            if (fix[start])
                toFix--;
            if (fix[i])
                toFix++;

            min = Math.min(min, toFix);
            start++;
        }

        System.out.println(min);
    }
}