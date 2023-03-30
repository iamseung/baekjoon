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
		for(int i=1;i<=N;i++) queue.offer(i);
    }

	static void pro()
	{
		int ans = queue.size();
		while(queue.size() > 1)
		{
			// 첫번째 요소 버림
			queue.poll();

			// 두번째 요소 빼서 뒤로 추가
			int two = queue.poll();
			queue.offer(two);
		}

		System.out.print(queue.poll());
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