import java.util.*;
class KAKAO22 {
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    
    public class Car {
        private int cost;
        private int row, col;
        private int dir;
        Car(int cost, int row, int col, int dir) {
            this.cost = cost;
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
        public String toString() {
            return cost + " " + row + " " + col +" " + dir;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
    
        int[][] dp = new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                dp[i][j] = -1;
            }
        }
        
        LinkedList<Car> q = new LinkedList<>();
        q.add(new Car(0, 0, 0, 0));
        q.add(new Car(0, 0, 0, 1));
        dp[0][0] = 0;
        
        while (!q.isEmpty()) {
            Car car = q.removeFirst();

            for (int i=0;i<4;i++) {
                int nr = car.row + dr[i], nc = car.col + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;
                
                if (board[nr][nc] == 1)
                    continue;
                
                if (Math.abs(car.dir - i) == 2)
                    continue;
                
                int newCost = car.cost + (car.dir == i ? 100 : 600);
                if (dp[nr][nc] == -1 || newCost <= dp[nr][nc]) {
                    dp[nr][nc] = newCost;
                    q.add(new Car(newCost, nr, nc, i));
                }
            }
        } 
        
        return dp[n-1][n-1];
    }
}
/**
 * [2020 카카오 인턴] 경주로 건설
 * 해결: X
 * 시간: 1H
 */

