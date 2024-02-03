import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
    
    static void process() {
        int[] dp = new int[N+1];
        dp[0] = 2;

        for(int i=1; i<=N; i++) {
            dp[i] = dp[i-1] + (dp[i-1] -1);
        }

        System.out.println(dp[N]*dp[N]);
    }
}