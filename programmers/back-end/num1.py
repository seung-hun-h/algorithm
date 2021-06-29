def solution(lottos, win_nums):
    lose = 0
    correct = 0
    
    rank = {
        6: 1,
        5: 2,
        4: 3,
        3: 4,
        2: 5,
        1: 6,
        0: 6
    }
    
    for lotto in lottos:
        if lotto in win_nums:
            correct += 1
        else:
            if lotto == 0:
                lose += 1
                
    return [rank[correct + lose], rank[correct]]