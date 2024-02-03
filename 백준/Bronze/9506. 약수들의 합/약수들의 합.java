import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int A,B;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        while(true) {
            String str = br.readLine();

            if(str.equals("-1")) break;

            list.add(Integer.parseInt(str));
        }
        
    }
    
    static void process() {
        for(int i : list) {
            List<Integer> L = new ArrayList<>();

            for(int j=1; j<i; j++) {
                if(i % j == 0) L.add(j);
            }

            if(valid(i, L)) {
                sb.append(i + " = " + L.get(0));
                for(int k=1; k<L.size(); k++) sb.append(" + " + L.get(k));
            } else {
                sb.append(i + " is NOT perfect.");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
        
    }

    static boolean valid(int S, List<Integer> L) {
        int SUM = 0;
        for(int l : L) SUM += l;

        return SUM == S;
    }
}