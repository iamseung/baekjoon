import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // N : 지방의 수, M : 총 예산
    // A : 각 지방의 예산요청 금액
    static int N, M;
    static int[] A;

    static void input() 
    {
        N = scan.nextInt();
        
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) 
        {
            A[i] = scan.nextInt();
        }

        M = scan.nextInt();
    }

    static boolean determination(int D) 
    {
        int sum = 0;

        for (int i = 1; i <= N; i++) 
        {
            sum += Math.min(A[i], D);
        }

        return sum <= M;
    }

    static void pro() 
    {
        Arrays.sort(A, 1, N + 1);

        int L = 0, R = A[N], ans = 0;

        while (L <= R) 
        {
            int mid = (L + R) / 2;

            if (determination(mid)) 
            {
                ans = mid;
                L = mid + 1;
            } 
            else 
            {
                R = mid - 1;
            }
        }

        System.out.println(ans);
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