class KAKAO21 {
    private static final int INF = 100000 * 200;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        int[][] dist = new int[n][n];
        distInitialize(dist, n, fares);
        
        for (int k=0;k<n;k++) {
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }        
        
        for (int i=0;i<n;i++) {
            answer = Math.min(answer, dist[s-1][i] + dist[i][a-1] + dist[i][b-1]);
        }
        return answer;
    }
    
    private void distInitialize(int[][] dist, int n, int[][] fares) {
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (i == j) continue;
                dist[i][j] = INF;
            }
        }
        
        for (int[] fare : fares) {
            dist[fare[0]-1][fare[1]-1] = fare[2];
            dist[fare[1]-1][fare[0]-1] = fare[2];
        }
    }
}
/***
 * [카카오 2021 공채] 합승 택시 요금
 * 해결: O
 */