import java.util.*;

class KAKAO32 {
    class Food {
        int idx;
        int amount;
        Food(int idx, int amount) {
            this.idx = idx;
            this.amount = amount;
        }
    }
    public int solution(int[] food_times, long k) {
        List<Food> foods = new ArrayList<>();
        
        for (int i=0;i<food_times.length;i++) {
            foods.add(new Food(i+1, food_times[i]));
        }
        
        Collections.sort(foods, (f1, f2) -> f1.amount - f2.amount);
        
        long prevAmount = 0;
        int n = food_times.length;
        
        for (int i=0;i<foods.size();i++) {
            long diff = (foods.get(i).amount - prevAmount) * n;
            if (diff > k) {
                k %= n;
                Collections.sort(foods.subList(i, foods.size()), (f1, f2) -> f1.idx - f2.idx);
                return foods.get(i + (int)k).idx;
            } else {
                k -= diff;
                prevAmount = foods.get(i).amount;
            }
            n--;
        }
        
        return -1;
    }
}
/**
 * [카카오 2019 공채] 무지의 먹방 라이브
 * 해결: X
 */