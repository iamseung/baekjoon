import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A;
    static int sum;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static void input() 
    {
        A = new int[9];
        for(int i=1; i<=8; i++)
        {
            A[i] = scan.nextInt();
            map.put(A[i], i);
        }
        
    }

    static void pro() 
    {
        Arrays.sort(A,1,9);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=4; i<=8; i++)
        {
            sum += A[i];
            arr.add(map.get(A[i]));
        }

        Collections.sort(arr);
        for(int k : arr) sb.append(k+" ");
        System.out.println(sum+"\n"+sb);
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