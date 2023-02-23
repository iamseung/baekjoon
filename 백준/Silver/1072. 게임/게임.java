import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long X, Y, Average;

    static void input() 
    {
        X = scan.nextLong();
        Y = scan.nextLong();
    }

    static boolean determination(int D) 
    {
        long ret = 100 * (Y + D) / (X + D);

        return ret > Average;
    }

    static void pro() 
    {
        Average = 100 * Y / X;
        int L = 0, R = 2000000000;

        if(Average >= 99) System.out.println("-1");
        else
        {
            while (L < R) 
            {
                int mid = (L + R) / 2;
    
                if (determination(mid)) 
                {
                    R = mid;
                } 
                else 
                {
                    L = mid + 1;
                }
            }
    
            System.out.println(R);
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