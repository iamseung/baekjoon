import java.util.*;
import java.io.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] Dy, A;

    public static void main(String[] args)
    {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        Dy = new int[N + 1];
    }

    static void pro() {
        // 초기값 구하기
        Dy[0] = 0;

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 1; i <= N; i++) 
        {
            /* 
             * 순회하면서 3번째까지의 최대 + 1번카드,
             * 2번째까지의 최대 + 2번카드 와 같이 모든 경우를 비교하며 최대값 갱신
            */
            for (int cnt = 1; cnt <= i; cnt++) 
            {
                Dy[i] = Math.max(Dy[i], Dy[i - cnt] + A[cnt]);
            }
        }

        // Dy배열로 정답 계산하기
        System.out.println(Dy[N]);
    }


    static void Dynamic()
    {
        
    }

    static class FastReader 
    {
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