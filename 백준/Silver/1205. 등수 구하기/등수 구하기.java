import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, tScore, P;
    static Integer[] score;

    static void input() 
    {
        N = scan.nextInt();
        tScore = scan.nextInt(); 
        P = scan.nextInt();

        score = new Integer[N];
        for(int i=0; i<N; i++) score[i] = scan.nextInt();
    }

	static void pro() 
    {  
        Arrays.sort(score, Collections.reverseOrder());

        // 점수와 랭크의 카운트가 같을 때, 새로 넣을 점수가 꼴지의 점수라면
        if(N == P && tScore <= score[score.length-1])
        {
            System.out.println(-1);
        }
        else
        {
            int rank = 1;
            for(int i=0; i<score.length; i++)
            {
                // 새로 넣을 점수가 기존의 점수보다 작을 경우 랭크를 증가
                if(tScore<score[i])
                    rank++;
                else
                    break;
            }

            System.out.println(rank);
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