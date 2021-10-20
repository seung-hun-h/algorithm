from sys import stdin
import collections
readline = stdin.readline

def solve():
    N, K = map(int, readline().split())

    while N != 0 and K != 0:
        numbers = collections.deque(list(map(int, readline().split())))
        tree = collections.defaultdict(set)
        parent = collections.defaultdict(int)
        roots = collections.deque([numbers.popleft()])
        while numbers:
            for _ in range(len(roots)):
                root = roots.popleft()
                child = numbers.popleft()
                tree[root].add(child)
                parent[child] = root
                roots.append(child)

                while numbers and numbers[0] == child+1:
                    child = numbers.popleft()
                    tree[root].add(child)
                    parent[child] = root
                    roots.append(child)
                
                if not numbers: break
            
        ansce = parent[parent[K]]
        print(sum(len(tree[node]) for node in tree[ansce] if K not in tree[node]))

        N, K = map(int, readline().split())
       
solve()