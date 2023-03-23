import java.io.*;
import java.util.*;

/*
 * 서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다는 것
 * 종료시간을 기준으로 정렬
 */
public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] dic;

    static void input() 
    {
        N = scan.nextInt();
        dic = new String[N+1];
        for(int i=1; i<=N; i++) dic[i] = scan.nextLine();
    }

    static void pro() 
    {
        // Arrays.sort(dic,1,N+1, new Comparator<String>() 
        Arrays.sort(dic,1,N+1, new Comparator<String>() 
        {
            @Override
            public int compare(String o1, String o2)
            {
                // 1. 길이가 짧은 것부터
                // 2. 길이가 같으면 사전 순으로
                if(o1.length() == o2.length()) return o1.compareTo(o2);
				else return o1.length() - o2.length();
            }
        });

        for(int i=1; i<=N; i++)
        {
            if(dic[i] == null) continue;

            // 정렬했기 때문에 직전만 확인
            if(!dic[i].equals(dic[i-1])) sb.append(dic[i]).append("\n");
        }

        System.out.println(sb);
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

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) 
            {
                try{
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e){
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