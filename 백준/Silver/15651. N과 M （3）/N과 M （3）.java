/*
 * https://www.acmicpc.net/problem/15651
 * 백준 15651
 */
import java.io.*;
import java.util.*;

public class Main 
{
    static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] selected;

    static void input()
    {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();

        // M번째까지 필요하기 때문에 M+1
        selected = new int[M + 1];
    }
	
	public static void main(String[] args) throws IOException
	{		
        input();

        // 1번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 탐색
        rec_function(1);

        System.out.println(sb.toString());
	}

    static void rec_function(int k)
    {
        // 다 찾은 경우
        if(k == M+1)
        {
            // selected[1~M] 배열이 새롭게 탐색된 결과
            for(int i=1;i<=M;i++)
            {
                sb.append(selected[i]).append(" ");
            }
            
            sb.append("\n");
        }
        else
        {
            // 1부터 N까지
            for(int cand = 1; cand <= N; cand++)
            {
                selected[k] = cand;

                // k+1 번부터 M 번까지 잘 채워주는 함수를 호출해준다.
                rec_function(k+1);

                // 탐색이 끝나면 0으로 초기화
                 selected[k] = 0;
            }
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