import java.util.*;
import java.io.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
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

        for(int i=1; i<=N; i++) A[i] = i;

        M = scan.nextInt();        
    }

    static void pro() 
    {
        while(M-- >0)
        {
            int x = scan.nextInt();
            int y = scan.nextInt();
            
            int ax = A[x];
            int ay = A[y];
            A[x] = ay;
            A[y] = ax;
        }
        
        for(int K : A)
        {   if(K == 0) continue;
            sb.append(K).append(" ");
        }

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