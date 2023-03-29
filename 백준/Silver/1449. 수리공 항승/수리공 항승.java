import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, T;
    static int[] A;

    static void input() 
    {
        N = scan.nextInt(); T = scan.nextInt(); 
        A = new int[N+1];
        for(int i=1; i<=N; i++) A[i] = scan.nextInt();
    }

    static void pro() 
    {
        Arrays.sort(A,1,N+1);

        int count = 1;
		int idx = 1;

		for (int j=idx+1; j<=N; j++) 
        {
            // 현재 좌표(idx) 부터 테이프의 길이(T) 만큼이 
            // 다음 좌표(j) 보다 작다면 count++ & 다음 좌표(j)부터 탐색 
			if (A[idx] + T - 1 < A[j]) 
            {
				count++;
				idx = j;
			}
		}

        System.out.println(count);
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