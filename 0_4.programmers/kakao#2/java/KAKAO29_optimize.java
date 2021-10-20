import java.util.*;
class KAKAO29_optimize {
    static final int INF = Integer.MAX_VALUE;
    int N, minCount;
    int[] Weak;
    int[] Dist;
    public int solution(int n, int[] weak, int[] dist) {
        N = n;
        Weak = weak;
        Dist = dist;
        minCount = INF;
        Arrays.sort(dist);
        for (int i=0;i<Weak.length;i++) {
            permutate(1, i, 0);
        }
        
        return minCount == INF ? -1 : minCount;
    }
    
    public void permutate(int cnt, int current, int visited) {
        if (cnt >= minCount || cnt > Dist.length)
            return;
        
        for (int i = 0;i < Weak.length;i++) {
            int next = (current + i) % Weak.length;
            int diff = Weak[next] - Weak[current];
            
            if (next < current)
                diff += N;
            
            if (diff > Dist[Dist.length - cnt])
                break;
            
            visited |= (1 << next);
        }
        
        if (visited == (1 << Weak.length) - 1) {
            minCount = cnt;
            return;
        }
            
        for (int i = 0;i < Weak.length;i++) {
            if ((visited & (1 << i)) != 0) continue;
            
            permutate(cnt + 1, i, visited);
        }
    }
}