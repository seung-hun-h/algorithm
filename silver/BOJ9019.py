from sys import stdin
from collections import deque

readline = stdin.readline


def get_min_command():
    init, target = map(int, readline().split())
    q = deque()
    visited = [False] * 10000
    q.append(['', init])
    visited[init] = True
    while q:
        c, n = q.popleft()
        visited[n] = True
        if n == target:
            return c

        dn = (n * 2) % 10000
        sn = n - 1 if n != 0 else 9999
        ln = int(n % 1000 * 10 + n / 1000)
        rn = int(n % 10 * 1000 + n // 10)
        if dn == target:
            return c + "D"
        if sn == target:
            return c + "S"
        if ln == target:
            return c + "L"
        if rn == target:
            return c + "R"

        if not visited[dn]:
            visited[dn] = True
            q.append([c + "D", dn])

        if not visited[sn]:
            visited[sn] = True
            q.append([c + "S", sn])

        if not visited[ln]:
            visited[ln] = True
            q.append([c + "L", ln])

        if not visited[rn]:
            visited[rn] = True
            q.append([c + "R", rn])


if __name__ == "__main__":
    T = int(readline().strip())
    for _ in range(T):
        print(get_min_command()) 