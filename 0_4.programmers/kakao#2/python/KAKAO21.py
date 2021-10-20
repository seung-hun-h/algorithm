def solution(n, s, a, b, fares):
    INF = int(10 ** 9)
    answer = INF
    dist = [[INF if i != j else 0 for i in range(n+1)] for j in range(n+1)]

    for c, d, f in fares:
        dist[c][d] = f
        dist[d][c] = f

    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    for i in range(1, n+1):
        answer = min(answer, dist[s][i] + dist[i][a] + dist[i][b])
    return answer

"""
[카카오 2021 공채] 합승 택시 요금
해결: O
"""