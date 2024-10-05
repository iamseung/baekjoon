import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static final int LEN = 41;
    static int[] vips;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        vips = new int[M + 1];
        for (int i = 1; i <= M; i++)
            vips[i] = Integer.parseInt(br.readLine());
    }

    static void process() {
        int[] dp = new int[LEN];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // 길이가 i 일 때 놓을 수 있는 경우의 수
        for (int i = 3; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        // 고정석을 기준으로 나눈 덩어리를 구해 갱신
        int answer = 1;

        for (int i = 1; i <= M; i++) {
            // 고정석 간의 길이
            int distance = vips[i] - vips[i - 1] - 1;
            answer *= dp[distance];
        }

        // 마지막 고정석부터 N까지의 덩어리 계산
        answer *= dp[N - vips[M]];
        System.out.println(answer);
    }
}