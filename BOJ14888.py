from sys import stdin
readline = stdin.readline

def get_min_max(oper_seq):
    if len(oper_seq) == N-1:
        cal_numbers(oper_seq)
        return

    for i in range(4):
        if opers[i] != 0:
            opers[i] -= 1
            get_min_max(oper_seq + [i])
            opers[i] += 1
    
def cal_numbers(oper_seq):
    global _min
    global _max
    global n_oper
    global m_
    res = numbers[0]
    for i in range(1, N):
        if oper_seq[i-1] == 0:
            res += numbers[i]
        elif oper_seq[i-1] == 1:
            res -= numbers[i]
        elif oper_seq[i-1] == 2:
            res *= numbers[i]
        else:
            if res < 0 or numbers[i] < 0:
                temp = abs(res) // abs(numbers[i])
                res = -temp
            else:
                res //= numbers[i]
   
    _min = min(_min, res)
    _max = max(_max, res)
 

if __name__ == '__main__':
    N = int(readline())
    numbers = list(map(int, readline().split()))
    opers = list(map(int, readline().split()))
    _min = 10**9
    _max = -10**9
    get_min_max([])
    print(_max)
    print(_min)