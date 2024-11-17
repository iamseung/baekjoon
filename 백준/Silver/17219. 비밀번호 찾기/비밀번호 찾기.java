import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static Map<String, String> words = new HashMap<>();
    static String[] sites;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sites = new String[M];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            words.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++)
            sites[i] = br.readLine();
    }

    static void process() {
        for (String s : sites)
            sb.append(words.get(s)).append("\n");

        System.out.println(sb.toString());
    }
}