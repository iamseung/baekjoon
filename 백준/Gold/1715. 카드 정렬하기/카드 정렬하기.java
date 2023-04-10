import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static PriorityQueue<Long> pq = new PriorityQueue<Long>();
    
    static void input() 
    {
        N = scan.nextInt();

        for(int i=1; i<=N; i++) pq.add(scan.nextLong());
    }

    static void pro() 
    {

        long sum = 0;

        //우선순위 큐에 2개이상 들어있어야 비교가 가능하다.
		while (pq.size() > 1) {
			long temp1 = pq.poll();
			long temp2 = pq.poll();
			
			sum += temp1 + temp2;
			pq.add(temp1 + temp2); //합한 묶음 다시 넣기
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