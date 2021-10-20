from collections import deque
def solution(cacheSize, cities):
    answer = 0
    q = deque()
    for city in cities:
        city = city.upper()
        # cache miss
        if city not in q:
            answer += 5
            q.append(city)

            if len(q) > cacheSize:
                q.popleft()
        # cache hit
        else:
            answer += 1
            # cache update
            q.remove(city)
            q.append(city)

    return answer
s = 3
c = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]

res = solution(s, c)
print(res)