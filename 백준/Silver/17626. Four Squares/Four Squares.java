import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        int[] dp = new int[N + 1];
        dp[1] = 1;

        int min = 0;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;

            // i에서 i보다 작은 제곱수에서 뺀 dp[i - j * j] 중
            // 최소를 택한다.
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min + 1; // 그리고 1을 더해준다.
        }

        System.out.println(dp[N]);
    }
}