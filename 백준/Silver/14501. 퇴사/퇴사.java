import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, ans;
    static int[] dp;
    static int[][] con;
    
    static void input() 
    {
        N = scan.nextInt();
        // 마지막 날 +5일의 경우, 배열 에러가 날 수 있으므로 넉넉하게 설정
        con = new int[N+10][2];
        dp = new int[N+10];

        for(int i=1; i<=N; i++)
        {
            con[i][0] = scan.nextInt(); // T
            con[i][1] = scan.nextInt(); // P
        }
    }

    static void pro() 
    {
        ans = Integer.MIN_VALUE;
        
        for(int i=1; i<=N+1; i++)
        {
            // 이전까지의 최대 수입을 비교해서 현재에 dp 에 저장해준다.
            dp[i] = Math.max(dp[i], ans);
            // 이번 동작으로 생긴 최대 수익과 이전에 저장된 최대 수익의 최대 값을 넣어준다.
            dp[con[i][0]+i] = Math.max(dp[con[i][0]+i], con[i][1]+dp[i]);
            // 최대 수익 저장
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) 
    {
        input();
        pro();
    }

    static class FastReader 
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() 
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException 
        {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() 
        {
            while (st == null || !st.hasMoreElements()) 
            {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() 
        {
            String str = "";
            try 
            {
                str = br.readLine();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}