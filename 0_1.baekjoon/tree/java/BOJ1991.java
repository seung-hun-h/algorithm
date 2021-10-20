import java.util.*;
import java.io.*;
public class BOJ1991{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String[]> graph = new HashMap<>();
        
        for(int i=0;i<N;i++){
            String[] line = br.readLine().split(" ");
            graph.put(line[0], new String[] {line[1], line[2]});
        }

        iterPreorder(graph, "A");
        System.out.println();
        iterInorder(graph, "A");
        System.out.println();
        iterPostorder(graph, "A");
    }
    public static void iterPreorder(Map<String, String[]> graph, String node){
        Stack<String> stack = new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node);
            
            if(!graph.get(node)[1].equals(".")){
                stack.add(graph.get(node)[1]);
            }
            if(!graph.get(node)[0].equals(".")){
                stack.add(graph.get(node)[0]);
            }
            
        }
    }
    public static void iterInorder(Map<String, String[]> graph, String node){
        Stack<String> stack = new Stack<>();

        while(!stack.isEmpty() || !node.equals(".")){
            while(!node.equals(".")){
                stack.add(node);
                node = graph.get(node)[0];
            }
            node = stack.pop();
            System.out.print(node);

            node = graph.get(node)[1];
        }
    }
    public static void iterPostorder(Map<String, String[]> graph, String node){
        Stack<String> stack = new Stack<>();

        while(!stack.isEmpty() || !node.equals(".")){
            while(!node.equals(".")){
                if(!graph.get(node)[1].equals(".")){
                    stack.add(graph.get(node)[1]);
                }
                stack.add(node);
                node = graph.get(node)[0];
            }
            
            if(stack.isEmpty())
                break;
            node = stack.pop();
            
            if(!graph.get(node)[1].equals(".") && !stack.isEmpty() && stack.peek().equals(graph.get(node)[1])){
                stack.pop();
                stack.add(node);
                node = graph.get(node)[1];
            } else {
                System.out.print(node);
                node = ".";
            }
        }
    }
}
