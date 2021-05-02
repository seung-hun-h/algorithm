def solution(n, arr1, arr2):
    answer = []
    
    for num1, num2 in zip(arr1, arr2):
        b = bin(num1 | num2)[2:]
        b = b.zfill(n)
        answer.append(b.replace("1", "#").replace("0", " "))
    return answer
n = 5
arr1 = [9, 20, 28, 18, 11]
arr2 = [30, 1, 21, 17, 28]
solution(n, arr1, arr2)