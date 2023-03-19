import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

	static int N;
	static long[][] Dy;

    static void input() 
	{
        N = scan.nextInt();
    }

	static void pro()
	{
		long ans = 0;
		for(int i=1; i<=9; i++) ans += Dy[N][i];
		// System.out.println(Arrays.toString(Dy[N]));
		sb.append(ans+1).append("\n");
		// System.out.println(ans+1);
	}

	static void dd()
	{
		Dy =  new long[65][10];
		
		for(int i=1; i<=9; i++)
		{
			Dy[1][i] = 1;
			Dy[2][i] = i+1;
		}
		
		for(int i=3; i<=64; i++)
		{
			for(int cur=1; cur<=9; cur++)
			{
				if(cur == 1)
				{
					// Dy[i][cur] = Dy[i-1][cur] + 1;
					Dy[i][cur] = i;
				}
				else
				{
					Dy[i][cur] = Dy[i][cur-1] + Dy[i-1][cur];
					 
				}
			}
		}
	}

    public static void main(String[] args) 
	{
		dd();
		int T = scan.nextInt();
		while(T-- >0)
		{
			input();
			pro();
		}

		System.out.println(sb);
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