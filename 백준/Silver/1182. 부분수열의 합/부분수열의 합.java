import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S, cnt;
    static int[] A;

    static void input()
    {
        N = scan.nextInt(); S = scan.nextInt();
        A = new int[N+1];
        for(int i=1; i<=N; i++) A[i] = scan.nextInt();
    }

    public static void main(String[] args)
    {
        input();
        
        recF(1,0);

        // ans 가 정말 "진 부분집합"만 다루는 지 확인하기
        if (S == 0) cnt--;

        System.out.println(cnt);
    }

    // k번째 원소를 포함시킬 지 정하는 함수
    // value:= k-1 번째 원소까지 골라진 원소들의 합
    static void recF(int k, int value)
    {
        // 부분 수열을 하나 완성 시킨 상태
        if(k == N+1)
        {
            if(value == S) cnt++;
        } 
        else
        {
            /*
             * k 번째 원소를 포함시킬 지 결정하고 재귀호출해주기 
             * 이렇게 하면 본인을 포함 및 미포함하는 모든 경우를 탐색
             */

           // [1] Include
           recF(k+1, value+A[k]);

           // [2] Not Include
           recF(k+1, value);
        }
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