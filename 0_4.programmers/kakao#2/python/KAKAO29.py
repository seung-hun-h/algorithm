from itertools import permutations

def solution(n, weak, dist):
    INF = float('inf')
    min_count = INF
    
    for start in range(len(weak)):
        for d in permutations(dist):
            current = start
            cnt = 1
            for i in range(len(weak)):
                _next = (start + i) % len(weak)
                diff = weak[_next] - weak[current]
                
                if _next < current:
                    diff += n
                
                if diff > d[cnt - 1]:
                    current = _next
                    cnt += 1
                    if cnt > len(dist) or cnt >= min_count:
                        break
                
            if cnt <= len(dist) and cnt < min_count:
                min_count = cnt
                
    return min_count if min_count != INF else -1