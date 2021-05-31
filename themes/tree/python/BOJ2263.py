from sys import stdin, setrecursionlimit
readline = stdin.readline
setrecursionlimit(10 ** 6)

N = int(readline())
inorder = list(map(int, readline().split()))
postorder = list(map(int, readline().split()))

def solve():
    index = dict()
    for i, n in enumerate(inorder):
        index[n] = i

    dfs(0, N-1, 0, N-1, index)

def dfs(in_s, in_e, post_s, post_e, index):
    if (in_s > in_e) or (post_s > post_e):
        return
    root = postorder[post_e]
    print(root, end=' ')
    left = index[root] - in_s # 왼쪽 서브 트리의 크기
    right = in_e - index[root] # 오른쪽 서브 트리의 크기

    dfs(in_s, in_s+left-1, post_s, post_s+left-1, index) # 왼쪽 서브트리    
    dfs(in_e-right+1, in_e, post_e-right, post_e-1, index) # 오른쪽 서브 트리

solve()