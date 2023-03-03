import java.util.*;
import java.io.*;

class Main
{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] A;

    static void input() 
    {
        N = scan.nextInt();

        A = new int[N+1];

        for(int i=1; i<=N; i++)
        {
            A[i] = i;
        }
    }

    static void pro()
    {
        int R = 0, cnt = 0;
        int sum = 0;

        // L 을 끝까지 탐색
        for(int L=1; L <= N; L++)
        {
            // 이전 값을 삭제
            sum -= A[L-1];

            // R을 N까지 모두 탐색, sum >= N 이면 루프 break;
            while(R+1 <= N && sum < N)
            {
                sum += A[++R];
            }

            // sum == N 인 경우를 카운트
            if(sum == N) cnt++;
        }

        System.out.println(cnt);
    
    }

    public static void main(String[] args) throws IOException
    {
        input();
        pro();
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
                try 
                {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() 
        {
            return Integer.parseInt(next());
        }

        long nextLong() 
        {
            return Long.parseLong(next());
        }

        double nextDouble() 
        {
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