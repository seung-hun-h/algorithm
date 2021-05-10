/**
 * test
 */
import java.util.*;
public class test {
    public static void main(String[] args) {
        String[] array = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(solution(8, 2, array));
    }
    public static String solution(int n, int k, String[] cmd) {
        int rear = n-1;
        int p = k;
        boolean[] current = new boolean[n];
        for(int i=0;i<n;i++){
            current[i] = true;
        }
        Stack<Integer> stack = new Stack<>();
        
        for(String command : cmd){
            String[] c = command.split(" ");
            if(c.length == 2){
                if(c[0].equals("U")){
                    int cnt = 0;
                    for(int i=p-1;i>=0;i--){
                        if(current[i] == true){
                            cnt++;
                        }
                        if(cnt == Integer.parseInt(c[1])){
                            p = i;
                            break;
                        }
                    }
                } else {
                    int cnt = 0;
                    for(int i=p+1;i<n;i++){
                        if(current[i] == true){
                            cnt++;
                        }
                        if(cnt == Integer.parseInt(c[1])){
                            p = i;
                            break;
                        }
                    }  
                }
            } else {
                if(c[0].equals("C")){
                    stack.push(p);
                    current[p] = false;
                    
                    if(p == rear){
                        for(int i=rear-1;i>=0;i--){
                            if(current[i] == true){
                                rear = i;
                                break;
                            }
                        }
                        p = rear;
                    } else {
                        for(int i=p+1;i<n;i++){
                            if(current[i] == true){
                                p = i;
                                break;
                            }
                        }
                    }
                } else {
                    int item = stack.pop();
                    current[item] = true;
                    if(item > rear){
                        rear = item;
                    }
                }
            } 
        }
        StringBuilder sb = new StringBuilder();
        for(boolean c : current){
            if(c == true){
                sb.append("O");
            } else {
                sb.append("X");
            }
        }
        return sb.toString();   
    }
}