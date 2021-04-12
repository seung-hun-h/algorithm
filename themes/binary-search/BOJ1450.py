from sys import stdin
readline = stdin.readline

N, C = map(int, readline().split())
arr = list(map(int, readline().split()))

def solve():
    ans = 0
    mid = len(arr) // 2
    left, right = arr[:mid], arr[mid:]

    left_sums, right_sums = [0], [0]
    get_perm_sums(left, 0, 0, left_sums)
    get_perm_sums(right, 0, 0, right_sums)

    right_sums.sort()

    for val in left_sums:
        # upper_bound > C-val 보다 큰 원소의 첫번째 위치 반환
        cnt = upper_bound(right_sums, C-val)
        ans += cnt

    print(ans)

def upper_bound(array, flag):
    left, right = 0, len(array) - 1
    while left < right:
        mid = (left + right) // 2

        if array[mid] < flag:
            left = mid + 1
        else:
            right = mid

    # array의 마지막 원소가 flag와 같은 경우
    if array[right] <= flag: 
        right += 1
    return right

def get_perm_sums(array, start, cur, res):
    for i in range(start, len(array)):
        if cur + array[i] <= C:
            res.append(cur + array[i])
            get_perm_sums(array, i+1, cur + array[i], res)
solve()