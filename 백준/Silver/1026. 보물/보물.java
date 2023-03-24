import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A, B;

    static void input() 
    {
        N = scan.nextInt();
        A = new int[N+1];
        B = new int[N+1];
        for(int i=1; i<=N; i++) A[i] = scan.nextInt();
        for(int i=1; i<=N; i++) B[i] = scan.nextInt();
    }

    static void pro() 
    {
        Arrays.sort(A, 1, N+1);
        Arrays.sort(B, 1, N+1);

        int sum = 0;

        for(int i=1; i<=N; i++)
        {
            sum += A[i]*B[(N-i)+1];
        }

        System.out.println(sum);
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