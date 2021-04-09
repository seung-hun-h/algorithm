import java.io.*;
import java.util.*;

public class BOJ20061 {
    static int[][] blue;
    static int[][] green;
    static int[][] commands;
    static int N;
    static int[] seq;
    static int[][][] blocks = {{{0, 0}}, {{0, 0}, {0, 1}}, {{0, 0}, {1, 0}}};
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        blue = new int[6][4];
        green = new int[6][4];
        commands = new int[N][3];

        for(int i=0;i<N;i++){
            String[] line = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                commands[i][j] = Integer.parseInt(line[j]);
            }
        }
        solve();
    }
    public static void solve(){
        for(int[] command : commands){
            drop(command[0], command[1], command[2]);
            delete(green);
            delete(blue);         
        }
        int sum = getSum(green) + getSum(blue);
        System.out.println(ans);
        System.out.println(sum);
    }
    public static int getSum(int[][] area){
        int sum = 0;
        for(int i=0;i<6;i++){
            for(int j=0;j<4;j++){
                sum += area[i][j];
            }
        }
        return sum;
    }
    public static void delete(int[][] area){
        // 한 행이 가득 찬 경우
        boolean[] deleteRows = new boolean[6];
        ArrayList<int[]> temp = new ArrayList<>();
        int[] zeros = {0, 0, 0, 0};
        int cnt = 0;
        for(int r=0;r<6;r++){
            deleteRows[r] = isFull(r, area);
            if(deleteRows[r]) cnt++;
        }
        ans += cnt;
        for(int i=0;i<cnt;i++){
            temp.add(zeros.clone());
        }

        for(int i=0;i<6;i++){
            if(!deleteRows[i]){
                temp.add(area[i].clone());
            }
        }

        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                if(temp.get(i)[j] == 1){
                    temp.remove(5);
                    temp.add(0, zeros.clone());
                }
            }
        }

        for(int i=0;i<6;i++){
            for(int j=0;j<4;j++){
                area[i][j] = temp.get(i)[j];
            }
        }

    }
    public static boolean isFull(int row, int[][] area){
        for(int c=0;c<4;c++){
            if(area[row][c] == 0){
                return false;
            }
        }
        return true;
    }
    public static void print(int[][] area){
        for(int[] b : area){
            for(int c : b){
                System.out.print(c +" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isPossible(int row, int col, int[][] block, int[][] area, boolean isBlue){
        int nx = 0, ny = 0, by = col;
        if(isBlue){
            for(int i=0;i<row;i++){
                for(int[] cell : block){
                    nx = i + cell[1];
                    ny = by - cell[0];
                    if(area[nx][ny] == 1){
                        return false;
                    }
                } 
            }
        } else {
            for(int i=0;i<row;i++){
                for(int[] cell : block){
                    nx = i + cell[0];
                    ny = by + cell[1];
                    if(area[nx][ny] == 1){
                        return false;
                    }
                } 
            }
        }
        return true;
    }
    public static void setBlock(int row, int col, int[][] block, int[][] area, boolean isBlue){
        if(isBlue){
            for(int[] cell : block){
                int nx = row + cell[1];
                int ny = col - cell[0];
                area[nx][ny] = 1;
            }
        } else {
            for(int[] cell : block){
                int nx = row + cell[0];
                int ny = col + cell[1];
                area[nx][ny] = 1;
            }
        }
    }
    public static void drop(int t, int x, int y){
        int[][] block = blocks[t-1];
        // Blue
        int bx = y; int by = 3 - x;
        // 블럭 둘 자리 찾기
        int nx = 0, ny = 0;
        for(int r=5;r>=0;r--){
            boolean flag = true;
            for(int[] cell : block){
                nx = r + cell[1];
                ny = by - cell[0];
                if(nx > 5 || ny < 0 || blue[nx][ny] == 1){
                    flag = false;
                    break;
                }
            }
            // 현재 행은 블럭을 둘 수 있는 후보군 중 하나.
            // 현재 행에 블럭을 두기 위해서는
            // 현재의 이전행에 블럭을 둘 열에 1이 없어야 함.
            // 만약 1이 있는 경우 그 위로 올라가야하기 때문(테트리스 생각)
            if(flag){
                flag = isPossible(r, by, block, blue, true);
                // 만일 위 행에 막히는 부분이 없으면
                // 블럭을 둔다.
                if(flag){
                    setBlock(r, by, block, blue, true);
                    break;
                }
            }
        }
        // Green
        nx = 0; ny = 0;
        for(int r=5;r>=0;r--){
            boolean flag = true;
            for(int[] cell : block){
                nx = r + cell[0];
                ny = y + cell[1];
                if(nx > 5 || ny > 5 || green[nx][ny] == 1){
                    flag = false;
                    break;
                }
            }
            if(flag){
                flag = isPossible(r, y, block, green, false);
                // 만일 위 행에 막히는 부분이 없으면
                // 블럭을 둔다.
                if(flag){
                    setBlock(r, y, block, green, false);
                    break;
                }
            }
        }
    }
}
