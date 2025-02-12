import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static String[] input;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
    }

    static void process() {
        int K = 1;
        int len = input[0].length();

        Set<String> set;
        while (len >= K) {
            set = new HashSet<>();

            for (String i : input)
                set.add(i.substring(len - K, len));

            if (set.size() == N)
                break;

            K++;
        }

        System.out.println(K);
    }

}