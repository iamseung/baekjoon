import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static int[][] arr;
    static boolean[] visit;
    static ArrayList<Integer> list = new ArrayList<>();

    static void input() 
    {
       N = scan.nextInt();
       M = scan.nextInt();
       arr = new int[N+1][N+1];
       visit = new boolean[N+1];
        
       while(M-- >0)
       {
            int x = scan.nextInt();
            int y = scan.nextInt();
            arr[x][y] = arr[y][x] = 1;
       }
    }

    static void pro() 
    {
        
        dfs(1);
        
        if(list.size() == 0)
            System.out.println(list.size());
        else
            System.out.println(list.size() - 1);
            
    }

    static void dfs(int x)
    {      
        visit[x] = true;
        
        list.add(x);

        for(int y=1; y<=N; y++)
        {
            if(arr[x][y] == 0) continue;
            // 이미 방문한 경우
            if(visit[y]) continue;

            dfs(y);
        }

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