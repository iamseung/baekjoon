import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void process(){
        long[] dp = new long[81];
        dp[1] = 4L;
        dp[2] = 6L;
        
        for(int i=3; i<=N; i++)
            dp[i] = dp[i-1] + dp[i-2];

        System.out.println(dp[N]);
    }
}