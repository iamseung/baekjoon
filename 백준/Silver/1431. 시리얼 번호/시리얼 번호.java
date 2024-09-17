import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<String> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            arr.add(br.readLine());
    }

    static void process() {
        arr.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';
                    if (num1 > 0 && num1 < 10) {
                        a += num1;
                    }
                    if (num2 > 0 && num2 < 10) {
                        b += num2;
                    }
                }

                if (a == b) {
                    return o1.compareToIgnoreCase(o2);
                }

                return a - b;
            }
        });

        arr.forEach(System.out::println);
    }
}