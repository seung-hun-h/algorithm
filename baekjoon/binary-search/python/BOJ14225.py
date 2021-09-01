from sys import stdin 
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))

def solve():
    perm_sum = []
    get_perm_sum(0, 0, perm_sum)

    perm_sum = list(set(perm_sum))
    perm_sum.sort()

    ans = search(perm_sum)
    print(ans)

def search(_sum):
    res = 1
    for num in _sum:
        if res != num:
            return res
        else:
            res += 1
    return _sum[-1]+1

def get_perm_sum(start, cur, res):
    for i in range(start, N):
        res.append(cur+arr[i])
        get_perm_sum(i+1, cur+arr[i], res)

solve()