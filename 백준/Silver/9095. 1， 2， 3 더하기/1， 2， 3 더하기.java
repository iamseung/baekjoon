import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int[] inp;

    static void input() 
    {
        T = scan.nextInt();
        inp = new int[T];

        for(int i=0; i<T;i++)
        {
            inp[i] = scan.nextInt();
        }

    }

    static void pro() 
    {
        int dp[] = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<= 11; i++)
        {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int k : inp)
        {
            sb.append(dp[k]).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
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

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
