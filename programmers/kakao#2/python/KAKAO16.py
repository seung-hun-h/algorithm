from collections import deque
def solution(cacheSize, cities):
    answer = 0
    cache = deque()
    
    for city in cities:
        city = city.lower()
        # cache miss
        if city not in cache:
            cache.append(city)
            
            if len(cache) > cacheSize:
                cache.popleft()
            
            answer += 5
        # cache hit
        else:
            cache.remove(city)
            cache.append(city)
            answer += 1
            
    return answer
"""
[2018 카카오 공채] 캐시
해결: O
"""