
public class LEET134 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0;
        int start = 0, fuel = 0;
        for (int i=0;i<gas.length;i++) {
            sumGas += gas[i];
            sumCost += cost[i];

            if (gas[i] + fuel < cost[i]) {
                start = i + 1;
                fuel = 0;
            } else {
                fuel += gas[i] - cost[i];
            }
        }
        return sumGas < sumCost ? -1 : start;
    }
}
