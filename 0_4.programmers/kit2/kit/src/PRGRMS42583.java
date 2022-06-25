import java.util.LinkedList;
import java.util.Queue;

public class PRGRMS42583 {
    public static void main(String[] args) {

    }

    static class Car {
        int time;
        int weight;

        Car (int weight) {
            this.weight = weight;
        }
        public void setTime(int time) {
            this.time = time;
        }
        public String toString() {
            return "time = " + time + "weight = " + weight;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Car> q = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            q.add(new Car(truckWeight));
        }

        Queue<Car> bridge = new LinkedList<>();
        int bridgeWeight = 0;
        int time = 0;

        while(!q.isEmpty() || !bridge.isEmpty()) {
            time++;
            if (bridge.isEmpty()) {
                Car car = q.poll();
                car.setTime(time);
                bridge.add(car);
                bridgeWeight += car.weight;
                continue;
            }

            if (time - bridge.peek().time == bridge_length) {
                bridgeWeight -= bridge.poll().weight;
            }

            if (!q.isEmpty() && q.peek().weight + bridgeWeight <= weight) {
                Car car = q.poll();
                car.setTime(time);
                bridge.add(car);
                bridgeWeight += car.weight;
            }

        }

        return time;
    }

}
