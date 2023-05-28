import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
	static int[] arr;

    static void input() 
    {
		N = scan.nextInt(); M = scan.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = scan.nextInt();
    }

	static void pro() 
    {   
		ArrayList<Integer> score = new ArrayList<>();

		int value = 0;

		for(int i=0;i<M; i++) value += arr[i];
		score.add(value);
		int max = value;

		// 5 2
		for(int i=1; i<=N-M; i++) // 3
		{
			value -= arr[i-1];
			value += arr[i+M-1];

			score.add(value);

			if(max < value) max = value;
		}

		int cnt = 0;
		for(int i=0; i<score.size(); i++)
		{
			if(score.get(i) == max) cnt++;
		}
		if(max == 0)
			System.out.println("SAD");
		else
			System.out.println(max+"\n"+cnt);
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