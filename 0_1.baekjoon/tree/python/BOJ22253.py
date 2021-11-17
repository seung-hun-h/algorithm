from sys import stdin, setrecursionlimit 
from collections import defaultdict
readline = stdin.readline
setrecursionlimit(10 ** 6)

tree = defaultdict(list)

N = int(readline())
nums = [0] + list(map(int, readline().split()))
dp = [[0 for _ in range(10)] for _ in range(N + 1)]
MOD = 1000000007

def solve():
    build_tree()
    dfs(-1, 1)

    print(sum(dp[1]) % MOD)

def dfs(parent, node):
    dp[node][nums[node]] = 1

    for adj in tree[node]:
        if adj == parent: continue
        
        dfs(node, adj)

        for i in range(10):
            dp[node][i] += dp[adj][i]
            dp[node][i] %= MOD

        for i in range(nums[node], 10):
            dp[node][nums[node]] += dp[adj][i]
            dp[node][nums[node]] %= MOD

def build_tree():
    '''
    u, v는 부모와 자식 방향이 보장되지 않음
    '''
    for _ in range(N - 1):
        u, v = map(int, readline().split())
        tree[u].append(v)
        tree[v].append(u)

solve()