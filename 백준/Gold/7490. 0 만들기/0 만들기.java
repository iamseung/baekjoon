import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[] ops = {"+", "-", " "};
    static List<String> ans;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            process();
        }
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void process(){
        ans = new ArrayList<>();
        recursion(1, "1");
        Collections.sort(ans);
        for(String s : ans)
            System.out.println(s);

        System.out.println();
    }

    public static void recursion(int num, String s) {
        if(num == N) {
            String express = s.replaceAll(" ", "");
            if(calculate(express))
                ans.add(s);

            return;
        }

        for(int i = 0; i < ops.length; i++) {
            recursion(num + 1, s + ops[i]+Integer.toString(num+1));
        }
    }

    public static boolean calculate(String str) {
        StringTokenizer st = new StringTokenizer(str, "-|+", true);
        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreElements()) {
            String s = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if(s.equals("+")) {
                sum += value;
            } else {
                sum -= value;
            }
        }

        return (sum == 0) ? true : false;
    }
}