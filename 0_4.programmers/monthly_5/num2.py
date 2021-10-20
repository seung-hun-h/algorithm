from collections import Counter
def solution(numbers):
    answer = []
    for number in numbers:
        bin_cur = bin(number)[2:]
        
        counter = Counter(list(bin(number ^ (number+1))[2:]))
        if counter['1'] <= 2:
            answer.append(number+1)
        else:
            bin_next = bin(number+1)[2:]
            bin_cur = "0" + bin_cur
            temp = bin_cur[::-1]
            end = 0
            for i in range(len(temp)):
                if temp[i] != "1":
                    temp = temp[:i-1] + "0" + "1" + temp[i+1:]
                    break
            answer.append(trans(temp))
    return answer

def trans(s):
    ten = 0
    for i in range(len(s)):
        if i == 0:
            x = 1 if s[int(i)] == '1' else 0
            ten += x
            
        else:
            if s[i] == '1':
                ten = ten + (2 ** i)
    return ten


solution([2, 7])