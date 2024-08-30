import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static final long MOD = 1_000_000_000L;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        // 자릿수, 0-9 로 시작하는 계단 수의 갯수
        long[][] dp = new long[N + 1][10];

        // 한 자릿수의 계단수는 모두 1개
        Arrays.fill(dp[1], 1L);

        for (int i = 2; i <= N; i++) {
            // 0 으로 시작하는 계단수, -1 자릿수의 1로 시작하는 수의 개수와 동일
            dp[i][0] = dp[i - 1][1];

            for (int j = 1; j <= 9; j++) {
                if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j + 1] % MOD) % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        System.out.print(result);
    }
}