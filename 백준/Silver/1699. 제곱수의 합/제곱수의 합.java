import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] dp;

    static void input() 
    {
        N = scan.nextInt();
        dp = new int[100001];
    }

    static void pro()
    {
        for(int i=1; i<=N; i++)
        {
            // 1로만 이루어진
            dp[i] = i;

            // 최소가 되는 제곱수 = n의 이전 수 들 중 제곱수 + n - 제곱수의 최수항 개수 
            for(int j=1; j*j<=i; j++)
            {
                if(dp[i] > dp[i-(j*j)] + 1) dp[i] = dp[i-(j*j)] + 1;
            }
        }
        System.out.println(dp[N]);
    }


    public static void main(String[] args) 
    {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
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

        String nextLine() {
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