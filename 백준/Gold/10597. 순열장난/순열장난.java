import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String input;
    static int LIMIT;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    public static void input() throws IOException {
        input = br.readLine();
    }

    public static void process(){
        LIMIT = (input.length()+7)/2+1;
        backTracking(input, new ArrayList<>());
    }

    public static void backTracking(String s, List<String> list) {
        if(s.equals("")) {
            StringBuilder sb = new StringBuilder();
            for(String l : list)
                sb.append(l + " ");

            System.out.println(sb.toString());
            System.exit(0);
        }

        String cur = "";
        int curV = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            cur += c;
            
            curV = Integer.parseInt(cur);

            if(curV > LIMIT || curV == 0)
                break;

            if(list.contains(cur))
                continue;

            list.add(cur);

            backTracking(s.substring(i+1, s.length()), list);

            list.remove(list.size()-1);
        }
    }
}