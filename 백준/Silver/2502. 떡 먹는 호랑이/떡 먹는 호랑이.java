import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A, B;
    static int[] dp;
    static int X, Y;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // 6
        B = Integer.parseInt(st.nextToken()); // 41
    }

    static void process() {
        dp = new int[B + 1];
        for (int i = 1; i < B; i++) {
            dp[1] = i;
            X = i;
            for (int j = i + 1; j < B; j++) {
                dp[2] = j;
                Y = j;
                recfunc(3);
            }
        }
    }

    static void recfunc(int depth) {
        if (depth == A) {
            if (dp[depth - 1] + dp[depth - 2] == B) {
                System.out.println(X);
                System.out.println(Y);
                System.exit(0);
            }
            return;
        }

        dp[depth] = dp[depth - 1] + dp[depth - 2];

        recfunc(depth + 1);
    }
}