import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, len;
    static int[] alpha;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            input();
            process();
        }

        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        alpha = new int[27];
        String input = br.readLine();
        for(char c : input.toCharArray())
            alpha[c - 'a']++;

        len = input.length();
    }

    public static void process(){
        set = new HashSet<>();
        backTracking(0, "");
        
        List<String> answer = set.stream()
                                .distinct()
                                .sorted()
                                .collect(Collectors.toList());

        for(String a : answer)
            sb.append(a).append("\n");
    }

    public static void backTracking(int depth, String parsedString) {
        if(depth == len) {
            set.add(parsedString);
            return;
        }

        for(int i=0; i<27; i++) {
            if(alpha[i] == 0)
                continue;
            
            alpha[i]--;
            backTracking(depth+1, parsedString + (char) (i + 'a'));
            alpha[i]++;
        }
    }
}