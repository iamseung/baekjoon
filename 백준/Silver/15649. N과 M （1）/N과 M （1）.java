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

        selected = new int[M + 1];
    }
	
	public static void main(String[] args) throws IOException
	{
    	input();
		
		rec_function(1);

		System.out.println(sb.toString());
	}

    static void rec_function(int k)
    {
        if(k == M+1)
        {
            for(int i=1;i<=M;i++)
            {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }
        else
        {
			// 1 - N까지 출력
            for(int cand = 1; cand <= N; cand++)
            {
				boolean isUsed = false;

                for(int i=1; i<k; i++)
				{
					if(cand == selected[i])
					{
						isUsed = true;
						continue;
					}
				}

				if(!isUsed)
				{
					selected[k] = cand;
					
					// k+1번 ~ M번을 모두 탐색하는 일
					rec_function(k+1);

					// 탐색이 끝나면 0으로 초기화
					selected[k] = 0;
				}
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