import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

public class PRGRMS42627 {
    public static void main(String[] args) {

    }

    static class Job {
        final int requestAt;
        final int spend;

        Job(int requestAt, int spend) {
            this.requestAt = requestAt;
            this.spend = spend;
        }

        public String toString() {
            return "requestAt = " + requestAt + " spend = " + spend;
        }
    }
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, comparingInt(j -> j[0]));
        PriorityQueue<Job> pq = new PriorityQueue<>(comparingInt(j -> j.spend));
        int idx = 0;
        int total = 0;
        int current = 0;

        while(idx < jobs.length || !pq.isEmpty()) {
            // System.out.println(pq + " " + total + " " + current);
            // 작업 큐에 인입
            for (;idx < jobs.length;idx++) {
                if (jobs[idx][0] > current) break;
                pq.add(new Job(jobs[idx][0], jobs[idx][1]));
            }

            if (pq.isEmpty()) {
                current = jobs[idx][0];
            } else {
                Job job = pq.poll();
                total += (current - job.requestAt + job.spend);
                current += job.spend;
            }

        }

        return total / jobs.length;
    }

}
