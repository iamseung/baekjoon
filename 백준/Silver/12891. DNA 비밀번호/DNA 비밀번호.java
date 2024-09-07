import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int S, P;
    static String DNA;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] alpha = new int[26];

    public static void main(String[] args) throws Exception {
        input();
        process();
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 문자열의 길이
        P = Integer.parseInt(st.nextToken()); // 사용할 부분 문자열의 길이
        DNA = br.readLine();
        st = new StringTokenizer(br.readLine());

        for (char c : "ACGT".toCharArray()) {
            // char to Integer
            map.put(c - 'A', Integer.parseInt(st.nextToken()));
        }
    }

    static void process() {
        int CNT = 0;

        // 첫 윈도우 계산
        for (int i = 0; i < P; i++) {
            alpha[DNA.charAt(i) - 'A']++;
        }

        if (isAvailble())
            CNT++;

        int start = 0;
        for (int i = P; i < S; i++) {
            alpha[DNA.charAt(start) - 'A']--;
            alpha[DNA.charAt(i) - 'A']++;

            if (isAvailble())
                CNT++;

            start++;
        }

        System.out.println(CNT);
    }

    static boolean isAvailble() {
        for (int c : map.keySet()) {
            int limit = map.get(c);
            if (alpha[c] < limit)
                return false;
        }

        return true;
    }
}