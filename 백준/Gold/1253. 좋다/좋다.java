import java.util.*;
import java.io.*;

class Main
{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException
    {
        input();
        pro();
    }

    static void input()
    {
        N = scan.nextInt(); // 수
        
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) 
        {
            A[i] = scan.nextInt();
        }
        
    }

    static void pro()
    {
        // 최소와 최대 GET
        Arrays.sort(A, 1, N+1);

        int ans = 0;
        
        for(int i=1; i<= N; i++)
        {
            if(func(i)) ans++;
        }

        System.out.println(ans);
    }

    static boolean func(int targetIdx)
    {
        // 탐색할 L, R 인덱스
        int L=1, R=N;

        // 탐색할 수
        int target = A[targetIdx];

        // 서로 다른 두 수를 골라야 하니 L과 R은 같으면 안됨
        while(L < R)
        {
            if(L == targetIdx)
            {
                L++;
            }
            else if(R == targetIdx) 
            {
                R--;
            }
            else
            {
                if(A[L]+A[R] > target)
                {
                    R--;
                }
                else if(A[L]+A[R] == target)
                {
                    return true;
                }
                else
                {
                    // A[L]+A[R] < target
                    L++;
                }
            }
        }
        return false;
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
                try 
                {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() 
        {
            return Integer.parseInt(next());
        }

        long nextLong() 
        {
            return Long.parseLong(next());
        }

        double nextDouble() 
        {
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