import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A,B;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }
    
    static void process() {
        for(int i=1; i<=A; i++) {
            if(A % i == 0) list.add(i);
        }

        System.out.println((list.size() < B) ? 0 : list.get(B-1));
    }
}