import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] A;

    static void input() 
    {
        N = scan.nextInt();
        A = new String[N+1];

        for(int i=1; i<=N; i++)
        {
            A[i] = scan.nextLine().split("\\.")[1];
        }
    }

    static void pro() 
    {
        // 사전순으로 출력하기 위한 정렬
        Arrays.sort(A,1,N+1);

        for(int i=1;i<=N;)
        {
            // 첫번째 요소부터 중복되는 요소에 대한 개수 체크
            // 본인을 체크하면서 cnt = 1로 해주고 i+1 부터 중복되지 않을 때까지 비교하면서 cnt++
            int cnt = 1, j = i + 1;
            for(;j <= N; j++)
            {
                // 같다[0], 작다[-1], 크다[1]
                if(A[j].compareTo(A[i]) == 0) cnt++;
                else break;
            }

            sb.append(A[i]).append(" ").append(cnt).append("\n");

            // A[j] != A[i] 일때 break 되거나 모두 찾은 상황
            // 즉, i는 j부터 다시 시작.
            i = j;
        }

        System.out.println(sb.toString());
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