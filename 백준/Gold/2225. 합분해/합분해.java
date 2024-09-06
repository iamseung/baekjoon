import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MOD = 1_000_000_000;
    static int N, K;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 0 부터 N 까지
        K = Integer.parseInt(st.nextToken()); // K 개를 더한다
    }

    /*
     * dp 0 1 2 3 4 5 6
     * 1 1 1 1 1 1 1 1
     * 2 1 2 3 4 5 6 7
     * 3 1 3 6 10 15 21 28
     * 4 1 4 10 20 35 56 84
     */
    static void process() {
        // dp, K 개를 선택해서 만드는 N 까지의 수
        int[][] dp = new int[K + 1][N + 1];

        // 하나를 선택해서 만들 수 있는 건 본인 자신 뿐
        Arrays.fill(dp[1], 1);

        // K 개를 선택해서 0을 만드는 방법은 한가지 뿐 (0+0+0 ..)
        for (int i = 1; i <= K; i++)
            dp[i][0] = 1;

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(dp[K][N]);
    }
}