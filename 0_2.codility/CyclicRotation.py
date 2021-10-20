import collections
def solution(A, K):
    # write your code in Python 3.6
    if not A:
        return []
    q = collections.deque(A)

    for _ in range(K):
        q.appendleft(q.pop())

    result = []
    while q:
        result.append(q.popleft())
    return result