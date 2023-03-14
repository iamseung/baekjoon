/*
 * 한자리씩 늘려가며 셀 수 있는 횟수를 저장해가는
 */
import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Dy;
    static int[] A;

    static void input() 
    {
        N  = scan.nextInt();
        Dy = new int[N+1][3];
        A  = new int[3];
    }

    static void pro() 
    {
        // Dy[i][j] = 1 ~ i번 집까지 칠했고, i번 집을 j번 색으로 칠하는 경우 중 최소 비용!
        Dy[0][0] = Dy[0][1] = Dy[0][2] = 0;

        for(int i = 1; i <= N; i++)
        {
            for(int j=0; j<3; j++) A[j] = scan.nextInt();
            Dy[i][0] = Math.min(Dy[i-1][1], Dy[i-1][2]) + A[0];
            Dy[i][1] = Math.min(Dy[i-1][0], Dy[i-1][2]) + A[1];
            Dy[i][2] = Math.min(Dy[i-1][1], Dy[i-1][0]) + A[2];
        }

        System.out.println(Math.min(Math.min(Dy[N][0], Dy[N][1]), Dy[N][2]));
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