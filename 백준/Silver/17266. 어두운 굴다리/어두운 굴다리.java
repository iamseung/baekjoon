import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
	static int[] width;

    static void input() 
    {
        N = scan.nextInt(); M = scan.nextInt();
		width = new int[M];
		for(int i=0; i<M; i++) width[i] = scan.nextInt();
    }

	static void pro() 
    {   
		int ans = binarySearch();

		System.out.println(ans);
	}

	static boolean possible(int target)
	{
		int prev = 0;

		for(int i=0; i<M; i++)
		{
			if(width[i] - target > prev) return false;

			prev = width[i] + target;
		}

		return prev >= N;
	}

	static int binarySearch()
	{
		int L = 1, R = N;

		while(L<=R)
		{
			int mid = (L+R)/2;

			if(possible(mid))
			{
				R = mid - 1;
			}
			else
			{
				L = mid+1;
			}
		}

		return L;
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