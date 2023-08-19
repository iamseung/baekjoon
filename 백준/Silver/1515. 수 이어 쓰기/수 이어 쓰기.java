import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int pt = 0;

        int base = 0;
        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(pt))
                    pt++;
                if (pt == s.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}