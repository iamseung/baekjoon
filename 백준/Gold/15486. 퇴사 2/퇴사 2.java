import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 2][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 기간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 금액
        }
    }

    public static void process() {
        // 마지막 날 기간이 1이 주어질 경우 일을 할 수 있는 경우를 감안
        int[] dp = new int[N + 2];

        int max = -1;
        for (int i = 1; i <= N + 1; i++) {
            // i 일까지의 최대 이익 갱신
            if (max < dp[i])
                max = dp[i];

            // i 일의 상담이 끝나는 날
            int next = i + arr[i][0];

            // 퇴사 전까지 상담을 끝낼 수 있으면
            if (next < N + 2) {
                dp[next] = Math.max(dp[next], max + arr[i][1]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}