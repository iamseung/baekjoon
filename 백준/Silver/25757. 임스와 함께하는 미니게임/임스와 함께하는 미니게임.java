import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, playerNum;
    static String game;
    static String[] player;
    static HashSet<String> H = new HashSet<>();

    static void input() 
    {
        N = scan.nextInt();
        game = scan.next();

        while(N-- > 0)
        {
            H.add(scan.nextLine());
        }
    }

	static void pro() 
    {  
        playerNum = 0;
        switch(game)
        {
            case "Y" : 
                playerNum = 1;
                break;
            case "F" : 
                playerNum = 2;
                break;
            case "O" : 
                playerNum = 3;
                break;
            default : 
                break;
        }

        System.out.println(H.size() / playerNum);
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