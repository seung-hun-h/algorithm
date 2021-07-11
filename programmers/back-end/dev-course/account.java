import java.util.*;
public class account {
    public int[] solution(int[] deposit) {
        Stack<Integer> stack = new Stack<>();

        for (int money : deposit) {
            if (money < 0) {
                while (money < 0) { // 통장에 입금된 금액보다 큰 금액을 출금하는 경우는 없다.
                    int lastDeposit = stack.pop();
                    int resid = lastDeposit + money;

                    if (resid > 0) {
                        stack.add(resid);
                        break;
                    }

                    money = resid;
                }
            } else {
                stack.add(money);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i=0;i<stack.size();i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] result = new account().solution(new int[]{500, 1000, -300, 200, -400, 100, -100});
        for (int r : result) {
            System.out.print(r+ " ");
        }
    }
}
