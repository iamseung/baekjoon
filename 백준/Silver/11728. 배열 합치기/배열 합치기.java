/*
 산성 용액과 알칼리성 용액의 특성값이 주어졌을 때, 이 중 두 개의 서로 다른 용액을 혼합하여 
 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
 */

import java.io.*;
import java.util.*;

public class Main 
{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N,M;
    static int[] A;

    static void input() 
    {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N+M+1];

        for(int i=1; i<=N; i++)
        {
            A[i] = scan.nextInt();
        }

        for(int i=N+1; i<= N+M; i++)
        {
            A[i] = scan.nextInt();
        }
 
    }

    static void pro() 
    {
        Arrays.sort(A, 1, N+M+1);
        for(int i=1; i<= N+M; i++)
        {
            sb.append(A[i]).append(" ");
        }

        System.out.println(sb);
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