import java.util.*;

class KAKAO27 {
    class Point {
        int row, col, count;
        
        Point(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    int[][] Board;
    int[][] D = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static final int INF = Integer.MAX_VALUE;
    public int solution(int[][] board, int r, int c) {
        Board = board;
        return permutate(new Point(r, c, 0));
    }
    
    private int permutate(Point src) {
        int result = INF;
        for (int num = 1;num <= 6;num++) {
            List<Point> points = new ArrayList<>();
            for (int r = 0;r < 4;r++) {
                for (int c = 0;c < 4;c++) {
                    if (Board[r][c] == num) {
                        points.add(new Point(r, c, 0));
                    }
                }
            }
            if (points.isEmpty())
                continue;
            
            int one = bfs(src, points.get(0)) + bfs(points.get(0), points.get(1)) + 2;
            int two = bfs(src, points.get(1)) + bfs(points.get(1), points.get(0)) + 2;
            
            for (int j=0;j<2;j++) {
                Board[points.get(j).row][points.get(j).col] = 0;
            }
            
            result = Math.min(result, one + permutate(points.get(1)));
            result = Math.min(result, two + permutate(points.get(0)));
            
            for (int j=0;j<2;j++) {
                Board[points.get(j).row][points.get(j).col] = num;
            }
            
        }
        
        return result == INF ? 0 : result;
    }
    
    private int bfs(Point start, Point end) {
        boolean[][] visited = new boolean[4][4];
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.row][start.col] = true;
        
        while (!q.isEmpty()) {
            Point point = q.poll();
            
            if (point.row == end.row && point.col == end.col) {
                return point.count;
            }
            
            for (int i=0;i<4;i++) {
                int nr = point.row + D[i][0], nc = point.col + D[i][1];
                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4)
                    continue;
                if (!visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, point.count + 1));
                }
                
                
                for (int j=0;j<2;j++) { // Shortcut
                    if (Board[nr][nc] != 0) break; // 이미 카드를 발견했을 경우
                    if (nr + D[i][0] < 0 || nr + D[i][0] >= 4 ||
                        nc + D[i][1] < 0 || nc + D[i][1] >= 4)
                        break;
                    nr += D[i][0];
                    nc += D[i][1];
                }
                
                if (!visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, point.count + 1));
                }
            }
        }
        
        return INF;
    }

    public static void main(String[] args) {
        System.out.println(
            new KAKAO27().solution(new int[][] {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}, 1, 0)
        );
    }
}
/**
 * [카카오 2021 공채] 카드 짝 맞추기
 * 해결: X 
 * 
 */