from sys import stdin, setrecursionlimit
readline = stdin.readline
setrecursionlimit(10 ** 6)

N = int(readline())
inorder = list(map(int, readline().split()))
postorder = list(map(int, readline().split()))

p_idx = len(postorder) - 1
def solve():
    index = dict()
    stack = []
    for i, n in enumerate(inorder):
        index[n] = i

    dfs(0, N-1, index, stack)
    stack.reverse()
    print(*stack)

def dfs(in_s, in_e, index, stack):
    global p_idx
    if in_s > in_e:
        return
    root = postorder[p_idx]
    p_idx -= 1

    dfs(index[root]+1, in_e, index, stack) # 오른쪽 서브 트리
    dfs(in_s, index[root]-1, index, stack) # 왼쪽 서브트리    
    stack.append(root)
solve()