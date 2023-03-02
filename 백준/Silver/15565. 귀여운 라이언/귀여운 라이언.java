import java.util.*;
import java.io.*;

class Main
{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, K;
    static int[] A;

    static void input() 
    {
        N = scan.nextInt();
        K = scan.nextInt();

        A = new int[N+1];

        for(int i=1; i<=N; i++)
        {
            A[i] = scan.nextInt();
        }
    }

    static void pro()
    {
        int R = 0, ans = N+1, cnt = 0;
        for(int L=1; L <= N; L++)
        {
            // A[L] 이 1(라이언)이 아니면 L 을 오른쪽으로 이동시킨다.
            if(A[L] != 1) continue;

            // R+1 을 N 까지 탐색시키고 cnt 가 K 와 같아지면 루프 break
            while(R+1 <= N && cnt < K)
            {
                if(A[++R] == 1) cnt++;
            }

            // 카운트의 갯수가 K를 만족하면 집합의 크기를 비교하여 최솟값을 저장
            if(cnt == K) ans = Math.min(ans, R-L+1);

            // L을 좌표를 옮기면서 현재 L은 1이기 때문에 -1 을 해주고 좌표를 옮긴다.
            cnt--;
        }

        if(ans == N+1) System.out.println(-1);
        else
            System.out.println(ans);
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