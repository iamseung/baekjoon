import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer t = new StringTokenizer(br.readLine());
        N = Integer.parseInt(t.nextToken());
        K = Integer.parseInt(t.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());
    }

    static void process() {
        Arrays.sort(coins);

        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            // 해당 coin 부터 K 까지
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        int result = (dp[K] == Integer.MAX_VALUE - 1) ? -1 : dp[K];
        System.out.println(result);
    }
}