import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan  = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static boolean[] prime;

    static void input() 
    {
        pro();
        while (true) 
        {
			int N = scan.nextInt();
			if (N == 0) break;

			boolean ans = false;

			for (int i = 2; i <= N / 2; i++) 
            {
                // 소수는 false
				if (!prime[i] && !prime[N - i]) 
                {
					System.out.println(N + " = " + i + " + " + (N - i));
					ans = true;
					break;
				}
			}
			if (ans == false) 
            {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
    }

    // 소수 구하기
	static void pro() 
    {
       prime = new boolean[1000001];
       prime[0] = prime[1] = true;

       for (int i = 2; i <= (int) Math.sqrt(1000000); i++) 
       { 
            for (int j = 2; i * j <= 1000000; j++) 
            {
                prime[i * j] = true; // 소수가 아님
            }
        }
    }


    public static void main(String[] args) 
	{
        input();
        // pro();
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