import java.util.*;
import java.io.*;

public class BOJ17837 {
    static int K;
    static int N;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);

        map = new int[N][N];

        ArrayList<Integer>[][] piece_map = new ArrayList[N][N];
        int[][] pieces = new int[K][3];

        for(int r=0;r<N;r++){
            String[] line = br.readLine().split(" ");
            for(int c=0;c<N;c++){
                map[r][c] = Integer.parseInt(line[c]);
                piece_map[r][c] = new ArrayList<Integer>();
            }
        }

        for(int i=0;i<K;i++){
            String[] line = br.readLine().split(" ");
            piece_map[Integer.parseInt(line[0])-1][Integer.parseInt(line[1])-1].add(i);
            pieces[i][0]= Integer.parseInt(line[0])-1;
            pieces[i][1]= Integer.parseInt(line[1])-1;
            pieces[i][2]= Integer.parseInt(line[2]);
        }
        
        System.out.println(solve(piece_map, pieces));
    }    
    public static int solve(ArrayList<Integer>[][] piece_map, int[][] pieces){
        boolean flag = false;

        for(int turn=1;turn<=1000;turn++){
            for(int i=0;i<K;i++){
                flag = move(i, piece_map, pieces);
                if(flag == true){
                    return turn;
                }
            }
        }
        return -1;
    }
    public static boolean move(int h, ArrayList<Integer>[][] piece_map, int[][] pieces){
        int r = pieces[h][0]; int c = pieces[h][1]; int d = pieces[h][2];

        int nr = r + dr[d-1]; int nc = c + dc[d-1];

        if((nr >= N || nr < 0 || nc >= N || nc < 0) || map[nr][nc] == 2){
            if(d == 1 || d == 2){
                d = (d + 2) % 2 + 1;
            } else {
                d = (d - 2) % 2 + 3;
            }

            nr = r + dr[d-1];
            nc = c + dc[d-1];
            if((nr >= N || nr < 0 || nc >= N || nc < 0) || map[nr][nc] == 2){
                pieces[h][2] = d;
                return false;
            }
        }
        
        int idx = 0;
        for(int i=0;i<piece_map[r][c].size();i++){
            if(piece_map[r][c].get(i) == h){
                idx = i;
                break;
            }
        }

        ArrayList<Integer> moving = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i=0;i<piece_map[r][c].size();i++){
            if(i < idx){
                temp.add(piece_map[r][c].get(i));
            } else{
                moving.add(piece_map[r][c].get(i));
            }
        }

        piece_map[r][c] = temp;
        temp = new ArrayList<>();
        if(map[nr][nc] == 1){
            for(int i=moving.size()-1;i>=0;i--){
                temp.add(moving.get(i));
            }
            moving = temp;
        }

        temp = new ArrayList<>();
        temp.addAll(piece_map[nr][nc]);
        temp.addAll(moving);

        pieces[h][0] = nr;
        pieces[h][1] = nc;
        pieces[h][2] = d;

        for(int i=0;i<moving.size();i++){
            if (moving.get(i) != h){
                pieces[moving.get(i)][0] = nr;
                pieces[moving.get(i)][1] = nc;
            }
        }

        piece_map[nr][nc] = temp;
        if(temp.size() >= 4){
            return true;
        }

        return false;
    }
}