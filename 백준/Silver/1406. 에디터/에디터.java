import java.io.*;
import java.util.*;

public class Main 
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N, index;
    static String str;
    static LinkedList<Character> list = new LinkedList<>();

    static void input() 
    {
        str = scan.nextLine();
        N = scan.nextInt();
        for(int i=0; i<str.length(); i++) list.add(str.charAt(i));            
    }

    static void pro()
    {
        ListIterator<Character> iter = list.listIterator();
        // 커서를 맨뒤로 이동 
        while(iter.hasNext()) iter.next();

        while(N-- > 0)
        {
            str = scan.nextLine();
            switch(str.charAt(0))
            {
                // 커서 왼쪽
                case 'L' : 
                    if(iter.hasPrevious()) iter.previous();
                    break;
                // 커서 오른쪽
                case 'D' : 
                    if(iter.hasNext()) iter.next();
                    break;
                // 문자 입력
                case 'P' : 
                    iter.add(str.charAt(2));
                    break;
                // 문자 삭제
                case 'B' : 
                    if(iter.hasPrevious())
                    {
                        iter.previous();
                        iter.remove();;
                    }
                    break;
            }
        }
        for(char S : list) sb.append(S);
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