import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

	static String str;

    static void input() 
	{
		str = scan.nextLine();
    }

	static void pro()
	{
		int sum = Integer.MAX_VALUE;

		// 입력받은 값을 모두 - 로 나눠준다.
		StringTokenizer st = new StringTokenizer(str, "-");

		while(st.hasMoreTokens())
		{
			int temp = 0;

			// - 로 나눈 섹션에서 + 로 모두 나눠서 총합을 구하고 빼주면 된다.
			StringTokenizer addition = new StringTokenizer(st.nextToken(), "+");

			while(addition.hasMoreTokens())
			{
				temp += Integer.parseInt(addition.nextToken());
			}

			// 첫번째 값은 빼지않기 위한 로직
			if(sum == Integer.MAX_VALUE)
			{
				sum = temp;
			}
			else
			{
				sum -= temp;
			}
		}

		System.out.println(sum);
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