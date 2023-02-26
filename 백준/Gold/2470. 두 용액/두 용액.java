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

    static int N;
    static int[] A;

    static void input() 
    {
        N = scan.nextInt(); // 수
        
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) 
        {
            A[i] = scan.nextInt();
        }
    }

    static void pro() 
    {
        Arrays.sort(A, 1, N+1);

        int bestSum = Integer.MAX_VALUE;
        int v1=0, v2=0,L=1,R=N; // L은 최소, R은 최대를 지정

        // L == R 의 상황은 용액 하나를 선택한 것이니 배제
        while(L < R)
        {
            // 용액 혼합

            // 모든 경우를 확인해가며 두 용액의 합이 0과 가까운 값으로 갱신
            if(bestSum > Math.abs(A[L]+A[R]))
            {
                bestSum = Math.abs(A[L]+A[R]);
                v1=A[L];
                v2=A[R];
            }

            /*
             * 두 용액의 합이 양수면 R의 감소시켜야 SUM 이 줄어들고 L을 늘려봤자 L은 음수이기 때문에 SUM 이 더 커짐
             * 음수면 L을 증가시켜야 SUM이 0 에 더 가까워 짐
             */
            if(A[L]+A[R] > 0)
            {
                R--;
            }
            else
            {
                L++;
            }
        }

        if(v1 < v2) sb.append(v1).append(" ").append(v2);
        else sb.append(v2).append(" ").append(v1);
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