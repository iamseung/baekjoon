import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        str = br.readLine();
    }

    static void process() {
        StringBuilder sb = new StringBuilder();
        
        for(char c : str.toCharArray()) {
            if(c - 'a' < 0) {
                sb.append(String.valueOf(c).toLowerCase());
            } else {
                sb.append(String.valueOf(c).toUpperCase());
            }
        }

        System.out.println(sb.toString());
    }
}