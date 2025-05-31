import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String args[]) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void process() {
        System.out.println(calGame());
    }

    public static String calGame() {
        // 7로 나눴을 때 나머지가 1 또는 3 인경우만 상근이가 패배
        return (N % 7 == 1 || N % 7 == 3) ? "CY" : "SK";
    }
}