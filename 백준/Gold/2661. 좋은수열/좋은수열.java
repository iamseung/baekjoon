import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    static void process() {
        backTracking("");
    }

    static void backTracking(String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (can_make_str(str + i))
                backTracking(str + String.valueOf(i));
        }
    }

    public static boolean can_make_str(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if (front.equals(back))
                return false;

        }

        return true;
    }
}