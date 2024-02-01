import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<String> strs = new ArrayList<>();
    
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            strs.add(br.readLine());
        }
        
    }
    
    static void process() {
        for(String s : strs) {
            StringTokenizer st = new StringTokenizer(s);
            String find = st.nextToken();
            String target = st.nextToken();

            sb.append(String.valueOf(target.charAt(findIndex(find))).toUpperCase());
        }

        System.out.println(sb.toString());
    }

    //  이 위치는 항상 유일
    static int findIndex(String findStr) {
        return (findStr.indexOf("x") == -1) ? findStr.indexOf("X") : findStr.indexOf("x");
    }
}