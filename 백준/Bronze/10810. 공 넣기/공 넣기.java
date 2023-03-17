import java.util.*;
import java.io.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, T;
    static int[] A;

    public static void main(String[] args)
    {
        input();
        pro();
    }

    static void input() 
    {
        N = scan.nextInt();
        A = new int[N+1];

        T = scan.nextInt();        
    }

    static void pro() 
    {
        while(T-- >0)
        {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int num = scan.nextInt();
            for(int i=x; i<=y; i++)
            {
                A[i] = num;
            }
        }

        for(int i=1;i<=N;i++)
        {
            sb.append(A[i]).append(" ");
        }
        // for(int K : A)
        // {
        //     sb.append(K).append(" ");
        // }

        System.out.println(sb);
    }

    static class FastReader 
    {
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