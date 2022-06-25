import java.util.PriorityQueue;
import java.util.Stack;

public class PRGRMS42584 {
    public static void main(String[] args) {

    }

    static class Stock {
        int value;
        int time;

        Stock(int value, int time) {
            this.value = value;
            this.time = time;
        }

        public String toString() {
            return "time = " + time + " value = " + value;
        }
    }
    public int[] solution(int[] prices) {
        Stack<Stock> stack = new Stack<>();
        int[] answer = new int[prices.length];
        int i=0;
        for (;i<prices.length;i++) {
            Stock stock = new Stock(prices[i], i);
            while (!stack.isEmpty() && stack.peek().value > stock.value) {
                Stock removed = stack.pop();
                answer[removed.time] = i - removed.time;
            }

            stack.add(stock);
        }


        for (Stock stock : stack) {
            answer[stock.time] = i - 1 - stock.time;
        }

        return answer;
    }

}
