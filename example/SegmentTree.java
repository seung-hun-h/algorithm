class SegmentTree {
    static int[] arr = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
    static int[] tree = new int[arr.length * 4];
    public static void main(String[] args) {
        init(0, arr.length - 1, 1);

        System.out.println("0 ~ 12 구간 합" + sum(0, arr.length - 1, 1, 0, 12));
        System.out.println("4 ~ 8 구간 합" + sum(0, arr.length - 1, 1, 4, 8));
        update(0, arr.length - 1, 1, 5, -5);
        System.out.println("4 ~ 8 구간 합" + sum(0, arr.length - 1, 1, 4, 8));
    }

    static int init(int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return tree[node];
        }

        int mid = (start + end) / 2;
        tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
        return tree[node];
    }

    static int sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start)
            return 0;
        
        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
    
    static void update(int start, int end, int node, int index, int dif) {
        if (index < start || index > end) return;

        tree[node] += dif;

        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}