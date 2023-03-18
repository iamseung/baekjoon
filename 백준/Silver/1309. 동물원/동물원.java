import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int MOD = 9901;
	static int N;
	static long[][] Dy;

    static void input() 
	{
        N = scan.nextInt();
		Dy = new long[N+1][3];
    }

    static void pro() 
	{
        Dy[1][0] = 1;
		Dy[1][1] = 1;
		Dy[1][2] = 1;

		for(int i=2; i<=N; i++)
		{
			Dy[i][0] = (Dy[i-1][0] + Dy[i-1][1] + Dy[i-1][2]) % MOD;
			Dy[i][1] = (Dy[i-1][0] + Dy[i-1][2]) % MOD;
			Dy[i][2] = (Dy[i-1][0] + Dy[i-1][1]) % MOD;
		}

		System.out.println((Dy[N][0]+Dy[N][1]+Dy[N][2])%MOD);
    }

    public static void main(String[] args) {
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