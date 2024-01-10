import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Double> score = new HashMap<>();
    static int CNT;
    static Double Total = 0.0;
    public static void main(String[] args) throws IOException {
        makeScores();
        input();
    }

    static void input() throws IOException {
        int T = 20;
        String[] line;

        while (T-- > 0) {
            line = br.readLine().split(" ");

            if(line[2].equals("P")) continue;

            Double S = Double.parseDouble(line[1]);
            Double rank = score.get(line[2]);
            Total += S * rank;
            CNT += S;
        }

        System.out.println(Math.round((Total/CNT) * 1000000) / 1000000.0);
    }

    static void makeScores() {
        score.put("A+", 4.5);
        score.put("A0", 4.0);
        score.put("B+", 3.5);
        score.put("B0", 3.0);
        score.put("C+", 2.5);
        score.put("C0", 2.0);
        score.put("D+", 1.5);
        score.put("D0", 1.0);
        score.put("F", 0.0);
    }
}