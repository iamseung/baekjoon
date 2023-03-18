import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;
    static int[][] DyM, DyL;

    static void input() 
    {
       N  = scan.nextInt();
       A  = new int[N+1][4];
       for(int i=1; i<=N; i++)
       {
            for(int j=1;j<=3;j++)
            {
                A[i][j] = scan.nextInt();
            }
       }

       DyM = new int[N+1][4];
       DyL = new int[N+1][4];
    }

    static void pro() 
    {
        DyM[1][1] = A[1][1];
        DyM[1][2] = A[1][2];
        DyM[1][3] = A[1][3];

        DyL[1][1] = A[1][1];
        DyL[1][2] = A[1][2];
        DyL[1][3] = A[1][3];

        for(int i=2 ; i<=N ;i++){   
            DyM[i][1] = Math.max(DyM[i-1][1], DyM[i-1][2]) + A[i][1];
            DyL[i][1] = Math.min(DyL[i-1][1], DyL[i-1][2]) + A[i][1];   

            DyM[i][2] = Math.max(Math.max(DyM[i-1][1], DyM[i-1][2]), DyM[i-1][3]) + A[i][2];
            DyL[i][2] = Math.min(Math.min(DyL[i-1][1], DyL[i-1][2]), DyL[i-1][3]) + A[i][2];      

            DyM[i][3] = Math.max(DyM[i-1][3], DyM[i-1][2]) + A[i][3];
            DyL[i][3] = Math.min(DyL[i-1][3], DyL[i-1][2]) + A[i][3];      
        }

        int max = Math.max(Math.max(DyM[N][1], DyM[N][2]), DyM[N][3]);
        int min = Math.min(Math.min(DyL[N][1], DyL[N][2]), DyL[N][3]);

        System.out.println(max+" "+min);
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