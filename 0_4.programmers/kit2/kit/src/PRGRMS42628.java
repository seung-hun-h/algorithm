import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

public class PRGRMS42628 {
    public static void main(String[] args) {

    }

    static class DoublePQ {
        private final PriorityQueue<Integer> minQ;
        private final PriorityQueue<Integer> maxQ;

        DoublePQ() {
            minQ = new PriorityQueue<>(Integer::compare);
            maxQ = new PriorityQueue<>((num1, num2) -> Integer.compare(num2, num1));
        }

        public void add(int number) {
            minQ.add(number);
            maxQ.add(number);
        }

        public void removeMax() {
            if (maxQ.isEmpty()) {
                return;
            }
            int max = maxQ.poll();
            Iterator<Integer> iter = minQ.iterator();
            while(iter.hasNext()) {
                int number = iter.next();
                if (number == max) {
                    iter.remove();
                    break;
                }
            }
        }

        public void removeMin() {
            if (minQ.isEmpty()) {
                return;
            }
            int min = minQ.poll();
            Iterator<Integer> iter = maxQ.iterator();
            while(iter.hasNext()) {
                int number = iter.next();
                if (number == min) {
                    iter.remove();
                    break;
                }
            }
        }

        public int[] result() {
            if (maxQ.isEmpty()) {
                return new int[] {0, 0};
            }
            return new int[] {maxQ.poll(), minQ.poll()};
        }

        public String toString() {
            return "maxQ = " + maxQ + " minQ = " + minQ;
        }
    }
    public int[] solution(String[] operations) {
        DoublePQ pq = new DoublePQ();
        for (String operation : operations) {
            String command = operation.split(" ")[0];
            int number = Integer.parseInt(operation.split(" ")[1]);

            if (command.equals("I")) {
                pq.add(number);
            } else {
                if (number == 1) {
                    pq.removeMax();
                } else {
                    pq.removeMin();
                }
            }

        }

        return pq.result();
    }

}
