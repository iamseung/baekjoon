import java.util.*;
import java.io.*;
 
class Node{
    int where;
    int time;
 
    public Node(int where, int time) {
        this.where = where;
        this.time = time;
    }
}
 
public class Main {
    static int n,k;
    static boolean [] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n= Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        check= new boolean[100002];
        solve();
    }
 
    public static void solve(){
        Queue<Node> queue =new ArrayDeque<>();
        queue.add(new Node(n, 0));
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.where==k){
                System.out.println(poll.time);
                return;
            }
 
            if(poll.where*2<=100001 && !check[poll.where*2]){
                queue.add(new Node(poll.where*2, poll.time));
                check[poll.where*2]=true;
            }
            if(poll.where-1>=0 &&!check[poll.where-1]){
                queue.add(new Node(poll.where-1, poll.time+1));
                check[poll.where-1]=true;
            }
            if(poll.where+1<=100001 && !check[poll.where+1]){
                queue.add(new Node(poll.where+1, poll.time+1));
                check[poll.where+1]=true;
            }
        }
    }
}