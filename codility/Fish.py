# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

UP_STREAM = 0
DOWN_STREAM = 1

def solution(A, B):
    # write your code in Python 3.6
    down = [] # DOWN_STREAM 방향 물고기 저장
    ans = 0 # 살아 남을 물고기 수 
    for i, _dir in enumerate(B):
        # 현재 물고기가 UP 방향
        if _dir == UP_STREAM:
            # 이전 물고기에 DOWN 방향이 없는 경우
            if not down:
                ans += 1
            else:
                while down and A[down[-1]] < A[i]:
                    down.pop()

                # 아래 물고기가 윗 물고기 모두 먹은 경우
                if not down:
                    ans += 1

        else:
            down.append(i)

    return ans + len(down)


    """ 
    다시!
    """