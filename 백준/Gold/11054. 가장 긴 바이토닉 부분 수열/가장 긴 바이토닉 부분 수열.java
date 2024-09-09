import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer[] r_dp;
    static Integer[] l_dp;
    static int[] seq;
    static int N;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        r_dp = new Integer[N]; // LIS dp
        l_dp = new Integer[N]; // LDS dp
        seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        LIS();
        LDS();

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < r_dp[i] + l_dp[i]) {
                max = r_dp[i] + l_dp[i];
            }
        }

        System.out.println(max - 1);
    }

    static void LIS() {
        for (int i = 0; i < N; i++) {
            r_dp[i] = 1;

            // 0 ~ i 이전 원소들 탐색
            for (int j = 0; j < i; j++) {
                // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if (seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
                    r_dp[i] = r_dp[j] + 1; // j번째 원소의 +1 값이 i번째 dp가 된다.
                }
            }
        }
    }

    static void LDS() {
        // 뒤에서부터 시작
        for (int i = N - 1; i >= 0; i--) {
            l_dp[i] = 1;
            // 맨 뒤에서 i 이전 원소들을 탐색
            for (int j = N - 1; j > i; j--) {
                // i번째 원소가 j번째 원소보다 크면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if (seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
                    l_dp[i] = l_dp[j] + 1; // j번쨰 원소의 +1이 i번쨰 dp값이 됨
                }
            }
        }
    }
}