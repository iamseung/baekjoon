import java.util.*;
import java.io.*;

public class Main {
    static int N,MAX = 1001;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = MAX;
        }
    }

    public static void process() {
        // 첫번째 칸은 제자리이기 때문에 0
        dp[1] = 0;
        for(int i=1; i<=N; i++) {
            // i+1 ~ i+1+arr[i] 는 점프할 수 있는 거리
            for(int j=i+1; j<i+1+arr[i]; j++) {
                // 범위 초과에 대한 예외처리
                if(j>N) continue;
                // i 에서 한칸 VS j 의 최솟 값을 저장
                dp[j] = Math.min(dp[i]+1, dp[j]);
            }
        }

        // 도달할 수 없으면 -1
        System.out.println(dp[N] == MAX ? -1 : dp[N]);
    }
}