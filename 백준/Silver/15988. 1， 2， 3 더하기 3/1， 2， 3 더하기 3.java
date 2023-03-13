import java.util.*;
import java.io.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static long Dy[];

    public static void main(String[] args)
    {
        input();
        pro();
    }

    static void input()
    {
        T = scan.nextInt();
    }

    static void pro()
    {
        Dynamic();

        while(T-- >0)
        {
            int X = scan.nextInt();
            sb.append(Dy[X]).append("\n");
        }

        System.out.println(sb);
    }

    static void Dynamic()
    {
        Dy = new long[1000000+1];

        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for(int i=4; i <= 1000000; i++)
        {
            Dy[i] = (Dy[i-1] + Dy[i-2] + Dy[i-3]) % 1000000009;
        }
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