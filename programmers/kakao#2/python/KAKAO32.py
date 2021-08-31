def solution(food_times, k):
    n = len(food_times)
    foods = sorted([[food, idx] for idx, food in enumerate(food_times, 1)], key = lambda x: x[0])
    
    prev_amount = 0
    
    for j, [amount, idx] in enumerate(foods):
        diff = (amount - prev_amount) * n

        if (diff > k):
            k %= n
            result = sorted(foods[j:], key = lambda x : x[1])
            return result[k][1]
        else:
            k -= diff
            prev_amount = amount
            
        n -= 1
    
    return -1
'''
[2019 카카오 공채] 무지의 먹방 라이브
해결: X
'''