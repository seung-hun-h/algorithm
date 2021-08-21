import java.util.*;
class KAKAO29 {
    static final int INF = Integer.MAX_VALUE;
    int result = INF;
    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        
        List<Integer> list = new ArrayList<>();
        
        for (int w : weak) {
            list.add(w);
        }
        permutate(n, list, dist, 0);
        return result == INF ? -1 : result;
    }
    
    public void permutate(int n, List<Integer> weaks, int[] dist, int count) {
        if (weaks.isEmpty() && count < result) {
            result = count;
            return;
        }
        
        if (count >= dist.length)
            return;

        for (int i=0;i<weaks.size();i++) {
            List<Integer> remains = new ArrayList<>();
            int start = weaks.get(i);
            int end = start + dist[dist.length - count - 1];
            
            for (int j=0;j<weaks.size();j++) {
                if (weaks.get(j) >= start && weaks.get(j) <= end)
                    continue;
                if (weaks.get(j) < start && weaks.get(j) + n <= end)
                    continue;
                remains.add(weaks.get(j));
            }
            permutate(n, remains, dist, count + 1);
        }
    }

    
}
/**
 * [카카오 2020 공채] 외벽 점검
 * 해결: O
 * 시간: 50분
 */