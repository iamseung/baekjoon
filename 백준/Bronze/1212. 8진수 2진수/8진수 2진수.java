import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String octat_num = br.readLine();

        for(int i=0; i<octat_num.length(); i++){
            int target = octat_num.charAt(i) - '0';
            String s = Integer.toBinaryString(target);
            if(s.length() == 3){
                sb.append(s);
            }
            else if(s.length()==2 && i!=0){
                sb.append("0" + s);
            }
            else if(s.length()==1 && i!=0){
                sb.append("00" + s);
            }
            else
                sb.append(s);
        }

        System.out.println(sb.toString());

    }
}