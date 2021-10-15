import java.io.*;
import java.util.*;

class BOJ21279 {

    static class Stone {
        int x, y, v;

        Stone(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, List<Stone>> xMap = new HashMap<>();
        Map<Integer, List<Stone>> yMap = new HashMap<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Stone stone = new Stone(x, y, v);

            xMap.putIfAbsent(x, new ArrayList<>());
            yMap.putIfAbsent(y, new ArrayList<>());

            xMap.get(x).add(stone);
            yMap.get(y).add(stone);
        }

        long ans = 0, current = 0;
        int cnt = 0;
        int xLimit = 0;
        int yLimit = 100000;

        while (xLimit <= 100000) {
            for (Stone stone : xMap.getOrDefault(xLimit, new ArrayList<>())) {
                if (stone.y > yLimit) continue;
                current += stone.v;
                cnt++;
            }

            while (cnt > C) {
                for (Stone stone : yMap.getOrDefault(yLimit, new ArrayList<>())) {
                    if (stone.x > xLimit) continue;
                    
                    current -= stone.v;
                    cnt--;
                }
                yLimit--;
            }

            ans = Math.max(ans, current);
            xLimit++;
        }

        System.out.println(ans);
    }
}