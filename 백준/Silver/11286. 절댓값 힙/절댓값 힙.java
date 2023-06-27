import java.io.*;
import java.util.*;

class Ele implements Comparable<Ele>
{
    int e;

    public Ele(int element)
    {
        this.e = element;
    }

    @Override
    public int compareTo(Ele other)
    {
        // 절대 값이 작으면 크기가 작은 것
        if(Math.abs(e) == Math.abs(other.e))
        {
            return e - other.e;
        }
        // 절대 값이 작은 순으로 정렬
        return Math.abs(e) - Math.abs(other.e);
    }
}

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, T, K;
    static PriorityQueue<Ele> Que = new PriorityQueue<>();
    
    static void input() 
    {
        N = scan.nextInt();
    }

    static void pro()
    {
        while(N-- > 0)
        {
            T = scan.nextInt();
            
            // 출력
            if(T == 0) {
                if(Que.size() == 0)
                {
                    sb.append("0\n");
                    continue;
                }
                
                sb.append(Que.poll().e+"\n");
                
            }
            // 입력
            else {
                Que.offer(new Ele(T));
            }
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

        String nextLine() {
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