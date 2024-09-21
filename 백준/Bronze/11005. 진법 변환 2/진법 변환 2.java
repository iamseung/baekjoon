import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int str1, str2;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        str1 = Integer.parseInt(st.nextToken());
        str2 = Integer.parseInt(st.nextToken());
    }

    static void process() {
        System.out.println(Integer.toString(str1, str2).toUpperCase());
    }
}