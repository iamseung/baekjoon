import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
	static int N;

    static void input() 
	{
		N = scan.nextInt();
    }

	static void pro()
	{
		while(N-- > 0)
		{
			String str = scan.nextLine();

			while(str.contains("()"))
			{
				str = str.replace("()", "");
			}

			if(str.length() == 0)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);
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