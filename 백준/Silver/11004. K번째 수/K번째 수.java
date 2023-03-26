import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, idx;
    static int[] D;

    static void input() 
    {
        N = scan.nextInt(); idx = scan.nextInt();
        D = new int[N+1];
        for(int i=1; i<=N; i++) D[i] = scan.nextInt();
    }        

    static void pro() 
    {
       Arrays.sort(D, 1, N+1);

       System.out.println(D[idx]);
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