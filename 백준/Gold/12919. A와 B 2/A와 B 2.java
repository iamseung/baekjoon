import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String before, after;
    static boolean isCorrect = false;
	public static void main(String[] args) throws IOException
	{
        input();
        pro(after);
        if(isCorrect) 
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static void input() throws IOException {
        before = br.readLine();
        after = br.readLine();
    }

    public static void pro(String s) {
        StringBuilder sb;
        if(s.length() == before.length()) {
            if(s.equals(before)) {
                isCorrect = true;
                return;
            }
        }
        else {
            sb = new StringBuilder(s);
            if(sb.charAt(s.length()-1) == 'A') {
                pro(sb.substring(0, s.length()-1).toString());
            }
            sb = sb.reverse();
            if(sb.charAt(s.length()-1) == 'B') {
                pro(sb.substring(0, s.length()-1).toString());
            }
            
        }
    }
}