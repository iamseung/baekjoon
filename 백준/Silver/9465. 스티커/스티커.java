import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;
    static int[][] Dy;

    static void input(){
        N  = scan.nextInt(); // N개
        A  = new int[N + 1][2];
        Dy = new int[N + 1][3];
        for (int j = 0; j < 2; j++) 
        {
            for (int i = 1; i <= N; i++) 
            {
                A[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() 
    {
        Dy[1][0] = 0;
        Dy[1][1] = A[1][0];
        Dy[1][2] = A[1][1];

        for(int i=2; i<=N; i++)
        {
            Dy[i][0] = Math.max(Dy[i-1][1], Dy[i-1][2]);
            Dy[i][1] = Math.max(Dy[i-1][0], Dy[i-1][2]) + A[i][0];
            Dy[i][2] = Math.max(Dy[i-1][0], Dy[i-1][1]) + A[i][1];
        }

        sb.append(Math.max(Math.max(Dy[N][0], Dy[N][1]), Dy[N][2])).append("\n");
    }

    public static void main(String[] args) 
    {
        int TT = scan.nextInt(); // case
        while (TT-- > 0) {
            input();
            pro();
        }

        System.out.println(sb);
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