import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // K : 오영식이 가지고 있는 랜선의 갯수
    // N : 필요한 랜선의 개수
    static int K,N;
    static int[] A;

    static void input() 
    {
        K = scan.nextInt();
        N = scan.nextInt();
        A = new int[K + 1];
        for (int i = 1; i <= K; i++) 
        {
            A[i] = scan.nextInt();
        }
    }

    // 각각의 랜선을 D의 길이로 나눈다면 최소 N개의 랜선을 확보할 수 있는가 ?
    static boolean determination(long D) 
    {
        long sum = 0;

        for (int i = 1; i <= K; i++) 
        {
            // i번째 랜선의 길이가 나누려는 길이 D보다 작다면 패스
            if(A[i] < D) continue;

            sum += A[i] / D;
        }

        // 나눈 랜선의 길이가 N보다 많은가 ?
        return sum >= N;
    }

    static void pro() 
    {
        // determination을 빠르게 하기 위해서 정렬해주자.
        Arrays.sort(A, 1, K + 1);

        long L = 1, R = Integer.MAX_VALUE, ans = 0;
        
        while (L <= R) 
        {
            long mid = (L + R) / 2;

            // mid 의 길이로 각각의 랜선을 나눴을 때, N개 이상을 얻을 수 있다면
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