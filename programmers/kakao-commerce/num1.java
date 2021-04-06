import java.util.*;
class num1 {
    public static void main(String[] args){
        int[] gift = {5, 4, 5, 4, 5};
        int[] wants = {1, 2, 3, 5, 4};
        solution(gift, wants);
    }
    public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        int cur = 0;
        int length = gift_cards.length;
        for(int i=0;i<gift_cards.length;i++){
            if (gift_cards[i] != wants[i]){
                cur++;
            }
        }
        
        System.out.println(dfs(gift_cards, wants, 0, cur, length));
        return answer;
    }
    
    public static int dfs(int[] gift, int[] wants, int idx, int cur, int length){
        if (idx >= length){
            return cur;
        }
        
        int v = cur;
        if(gift[idx] == wants[idx]){
            v = Math.min(v, dfs(gift, wants, idx+1, cur, length));
        } else {
            for(int i=idx+1;i<length;i++){
                if(wants[idx] == gift[i] && gift[i] != wants[i]){
                    int temp = gift[idx];
                    gift[idx] = gift[i];
                    gift[i] = temp;
                    if(gift[i] == wants[i]){
                        v = Math.min(v, dfs(gift, wants, idx+1, cur-2, length));                        
                    } else {
                        v = Math.min(v, dfs(gift, wants, idx+1, cur-1, length));
                    }
                    temp = gift[idx];
                    gift[idx] = gift[i];
                    gift[i] = temp;
                }
            }
            v = Math.min(v, dfs(gift, wants, idx+1, cur, length));    
        }
        return v;
    }
}