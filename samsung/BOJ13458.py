from sys import stdin
readline = stdin.readline

def get_min_supervisor():
    # 각 시험 장에는 총 감독관이 반드시 한 명 존재해야함.
    # 부감독관은 0 or 여러 명 가능
    res = len(students)
    for i in range(len(students)):
        students[i] -= B
        if students[i] > 0:
            res += students[i] // C
            if students[i] % C != 0:
                res += 1
    
    return res

if __name__ == '__main__':
    N = int(readline())
    students = list(map(int, readline().split()))
    B, C = map(int, readline().split())
    
    print(get_min_supervisor())