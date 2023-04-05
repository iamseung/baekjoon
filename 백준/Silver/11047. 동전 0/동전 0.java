import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
	static int N,M;
	static int[] Money;

    static void input() 
	{
		N = scan.nextInt();
		M = scan.nextInt();
		Money = new int[N+1];
		for(int i=1; i<=N; i++) Money[i] = scan.nextInt();
    }

	static void pro()
	{
		int cnt = 0;
		int pay = M;
		for(int i = N; i>0; i--)
		{
			if(Money[i] <= pay)
			{
				cnt += pay/Money[i];
				pay = pay%Money[i];
			}
		}

		System.out.println(cnt);
	}

    public static void main(String[] args) 
	{
		input();
		pro();
    }


    static class FastReader {
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