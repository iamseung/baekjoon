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
        N = scan.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1][10];
    }

    static void pro() 
    {
        // 초기값 구하기
        // = 한자릿수 오르막 수는 본인 자신뿐
        for (int num = 0; num <= 9; num++) Dy[1][num] = 1;

        // 점화식을 토대로 Dy 배열 채우기
        // 두자릿수부터
        for (int len = 2; len <= N; len++) 
        {
            // 0~
            for (int num = 0; num <= 9; num++) 
            {
                // 길이가 len이고 num으로 끝나는 개수를 계산하자 == Dy[len][num] 을 계산하자.
                // Dy[len][num] 은 Dy[len-1][0 ~ num] 즉, -1 자릿수의 num까지의 합이다!
                for (int prev = 0; prev <= num; prev++) 
                {
                    Dy[len][num] += Dy[len - 1][prev];
                    Dy[len][num] %= 10007;
                }
            }
        }

        // Dy배열로 정답 계산하기
        // 문제에서 길이만 주어지기 때문에 0~9까지 모두 더하면 됨!
        int ans = 0;
        for (int num = 0; num <= 9; num++) 
        {
            ans += Dy[N][num];
            ans %= 10007;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
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