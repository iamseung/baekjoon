import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] item, dp;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 물품의 수
        K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        item = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken()); // 물건의 무게
            item[i][1] = Integer.parseInt(st.nextToken()); // 물건의 가치
        }

        dp = new int[N + 1][K + 1];
    }

    // 배낭에 넣을 수 있는 물건들의 가치합의 최댓갑
    // N 물품의 수, K 버틸 수 있는 무게
    static void process() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                int weight = item[i][0];
                int value = item[i][1];

                // i번째 무게를 더 담을 수 없는 경우
                if (weight > j) {
                    // i-1 번째와 가치에서 변함이 없음
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 물건을 넣는 경우와 넣지 않는 경우를 비교
                    // 물건을 넣는다면 K 에서 무게를 빼고 가치를 더함
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}