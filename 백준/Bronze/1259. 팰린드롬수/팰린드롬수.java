import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

	static int T;

    static void input() 
	{
		// T = scan.nextInt();
    }

	static void pro()
	{
		while(true)
		{
			String str = scan.nextLine();
			
			if(str.equals("0")) break;

			int size = str.length();
			
			String ans = "yes";
			
			for(int i=0; i<str.length() / 2; i++)
			{
				if(str.charAt(i) - str.charAt(size-i-1) != 0){
					ans = "no";
					break;
				}
			}

			sb.append(ans+"\n");
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