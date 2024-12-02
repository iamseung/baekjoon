import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] minusH;
    static int[] plusP;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        minusH = new int[N+1];
        plusP = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            minusH[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            plusP[i] = Integer.parseInt(st.nextToken());
    }

    public static void process(){
        int K = 99;

        int[][] dp = new int[N+1][K+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                if(minusH[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j-minusH[i]]+plusP[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.print(dp[N][K]);
    }
}