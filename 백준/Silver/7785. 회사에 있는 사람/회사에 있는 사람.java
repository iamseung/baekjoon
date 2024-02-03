import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> strs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static void input() throws IOException {
        int N = Integer.parseInt(br.readLine());

        while(N-- >0) {
            strs.add(br.readLine());
        }
    }
    
    static void process() {
        Map<String, Integer> M = new HashMap<>();

        for(String s : strs) {
            StringTokenizer st = new StringTokenizer(s);
            String name = st.nextToken();
            String log = st.nextToken();

            if(log.equals("enter")) {
                // 출근
                M.put(name, 1);
            } else {
                // 퇴근
                M.put(name, 0);
            }
        }

        List<String> leaves = new ArrayList<>();

        for( Map.Entry<String,Integer> entry : M.entrySet() ){
            String strKey = entry.getKey();
            if(entry.getValue() == 1) leaves.add(strKey);
        }
        
        Collections.sort(leaves, Collections.reverseOrder());

        for(String S : leaves) System.out.println(S);
        
    }

}