def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    check = [False] * 46
    length = len(lottos)
    
    for win in win_nums:
        check[win] = True
    cnt = 0
    zeros = 0
    for lotto in lottos:
        if lotto == 0: 
            zeros += 1
            continue
        if check[lotto]:
            cnt += 1

    answer = [rank[cnt+zeros], rank[cnt]]
    print(answer)


    

solution([41, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19])