import java.io.*;
import java.util.*;
import java.util.stream.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int index = 1;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            pro();
        }

        System.out.println(sb.toString());
    }

    static void pro() throws IOException {
        String str = br.readLine();
        String answer = "YES";

        int N = str.length();

        if(!check(str) || !check(str.substring(0,(N-1)/2)) ||  !check(str.substring((N-1)/2+1,N))) {
            answer = "NO";
        }
        
        sb.append("#" + index++ + " " + answer +"\n");
    }

    static boolean check(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}