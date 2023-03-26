import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A;
    static int N, cnt;

    static void input() 
    {
        // 입력을 받고 , 수의 길이를 N으로 init
        String str = scan.nextLine();
        N = str.length();
        A = new int[N+1];
        
        for(int i=1; i<=N; i++)
        {
            A[i] = str.charAt(i-1) - 48;

            // 각 자리의 숫자를 모두 더함
            cnt += A[i];
        }
    }

    static void pro() 
    {
        // 오름차순 정렬
        Arrays.sort(A, 1, N+1);

        // 모든 자리 수의 합이 3이여야 하고 뒤에 0이 와야 30의 배수,
        // 제외한 경우는 30의 배수가 아님
        if((cnt % 3 == 0) && (A[1] == 0))
        {
            for(int i=N; i>0; i--)
            {
                System.out.print(A[i]);
            }
        } 
        else
        {
            System.out.print(-1);
        }
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