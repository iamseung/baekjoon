import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() 
    {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1]; // 1-M 까지
        B = new int[M + 1]; // 1-N 까지
        for (int i = 1; i <= N; i++) 
        {
            A[i] = scan.nextInt();
        }

        for (int i = 1; i <= M; i++) 
        {
            B[i] = scan.nextInt();
        }
    }

    // A[L - R]dptj x 미나의 수 중 제일 오른쪽 인덱스를 return 
    // 없다면 L-1 return
    static int lower_bound(int[] A, int L, int R, int X)
    {
        int result = L - 1;

        while(L <= R)
        {
            int mid = (L+R)/2; // 중간 값 설정

            if(A[mid] < X)
            {
                result = mid;
                L = mid+1;
            }
            else if (A[mid] >= X)
            {
                // X보다 작은 수를 찾아야 하니 더 큰 값은 가치가 없으므로 범위를 줄임
                R = mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) 
    {
        int TT; // 테스트 케이스 수
        TT = scan.nextInt();
        for (int tt = 1; tt <= TT; tt++) {
            input();
            pro();
        }
    }

    static void pro()
    {
        // 이분탐색을 위한 정렬
        Arrays.sort(B, 1, M+1);

        int ans = 0;

        for(int i=1;i<=N;i++)
        {
            ans += lower_bound(B, 1, M, A[i]);
        }

        System.out.println(ans);
    }


    static class FastReader 
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() 
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException 
        {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() 
        {
            while (st == null || !st.hasMoreElements()) 
            {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
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

        String nextLine() 
        {
            String str = "";
            try 
            {
                str = br.readLine();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}