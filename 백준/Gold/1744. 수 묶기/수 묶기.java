import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer> plus = new ArrayList<>();
    static ArrayList<Integer> minus = new ArrayList<>();

    static void input() 
    {
        N = scan.nextInt(); 

        for(int i=1; i<=N; i++)
        {
            int X = scan.nextInt();
            if(X > 0) 
                plus.add(X);      
            else
                minus.add(X);
        }
    }

    static void pro() 
    {
        // 양수는 내림차순, 음수는 오름차순 정렬
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int sum = 0;
        int i   = 0;

		while (i < plus.size()) 
        {
            // 값이 1인 경우에는 곱하는 것보다 더하는 값이 더 크기 때문에 더함
            // else 로 홀수 수열의 경우 예외처리
			if (i + 1 < plus.size() && plus.get(i) != 1 && plus.get(i + 1) != 1)
				sum += plus.get(i++) * plus.get(i++);
			else
				sum += plus.get(i++);
		}

        i = 0;
		while (i < minus.size()) 
        {
			if (i + 1 < minus.size())
				sum += minus.get(i++) * minus.get(i++);
			else
				sum += minus.get(i++);
		}
        System.out.println(sum);
    }

    public static void main(String[] args) 
    {
        input();
        pro();
    }

    static class FastReader 
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() 
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException 
        {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() 
        {
            while (st == null || !st.hasMoreElements()) 
            {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
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

        String nextLine() 
        {
            String str = "";
            try 
            {
                str = br.readLine();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}