import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] Dy;

    static void input() 
    {
        N  = scan.nextInt();
        
    }

    static void pro() 
    {
        procedure();
        System.out.println(Dy[N]);
    }

    static void procedure()
    {
        Dy = new long[90 + 1];

        Dy[0] = 1;
        Dy[1] = 1;
        Dy[2] = 1;
        Dy[3] = 2;
        
        for(int i=4; i<=90; i++)
        {
            int x = i-2;
            while(x >=0)
            {
                Dy[i] += Dy[x];
                x--;
            }
        }
        
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