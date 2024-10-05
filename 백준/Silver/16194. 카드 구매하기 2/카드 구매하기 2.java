import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] cards;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        cards = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            cards[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        int[] dp = new int[N + 1];

        // 금액 루프
        for (int i = 1; i <= N; i++) {
            // 최소값 초기화
            dp[i] = cards[i];

            for (int j = 1; j <= i; j++) {
                /*
                 * j 라는 카드팩 개수가 i 라는 금액보다 커지는 경우엔 계산할 수 없음 => 0
                 * i 라는 금액에 대해서 j번째 카드로만 가득 채우는 경우와
                 * i-j 의 최소값 + j 의 카드 값을 더한 것을 비교하며 채워가는 과정
                 */
                dp[i] = Math.min(dp[i], dp[i - j] + cards[j]);
            }
        }

        System.out.println(dp[N]);
    }
}