def solution(n, s, a, b, fares):
    INF = int(10 ** 6)
    answer = INF
    dist = [[INF if i != j else 0 for i in range(n+1)] for j in range(n+1)]

    for c, d, f in fares:
        dist[c][d] = f
        dist[d][c] = f

    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

    
    for i in range(1, n+1):
        answer = min(answer, dist[s][i] + dist[i][a] + dist[i][b])
    return answer

res = solution(6,	4,	6,	2,	[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]])
print(res)