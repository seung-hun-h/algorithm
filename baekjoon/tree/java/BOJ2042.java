import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BOJ2042 {
    static int N, M, K;
    static long[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new long[N+1];
        tree = new long[N * 4];

        for (int i=1;i<=N;i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, N, 1);
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<M+K;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, diff);
            } else if (a == 2){
                sb.append(sum(1, N, 1, b,(int)c)+ "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long init(int start, int end, int node) {
        if (start == end) 
            return tree[node] = arr[start];

        int mid = (start + end) >>> 1;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void update(int start, int end, int node, int idx, long diff) {
        if (start > idx || end < idx)
            return;
        
        tree[node] += diff;

        if (start == end)
            return;

        int mid = (start + end) >>> 1;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }

    static long sum(int start, int end, int node, int left, int right) {
        if (start > right || end < left)
            return 0;

        if (start >= left && end <= right)
            return tree[node];

        int mid = (start + end) >>> 1;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}