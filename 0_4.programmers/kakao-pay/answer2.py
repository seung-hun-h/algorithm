def solution(rows, columns, swipes):
    answer = []
    matrix = build_matrix(rows, columns)
    
    for swipe in swipes:
        for m in matrix:
            print(m)
        print()
        d, r1, c1, r2, c2 = swipe

        sub_mat = [[matrix[r][c] for c in range(c1-1, c2)] for r in range(r1-1, r2)]

        if d == 1: # 아래
            answer.append(sum(sub_mat[-1]))
            sub_mat = [sub_mat.pop()] + sub_mat
        elif d == 2: # 위
            sub_mat.append(sub_mat[0][:])
            answer.append(sum(sub_mat[0]))
            sub_mat = sub_mat[1:]
        elif d == 3: # 우
            temp = [sub_mat[r].pop() for r in range(len(sub_mat))]
            answer.append(sum(temp))
            for r in range(len(sub_mat)):
                sub_mat[r] = [temp[r]] + sub_mat[r]
        else: # 좌
            temp = 0
            for r in range(len(sub_mat)):
                temp += sub_mat[r][0]
                sub_mat[r] = sub_mat[r][1:] + [sub_mat[r][0]]

            answer.append(temp)

        for r in range(len(sub_mat)):
            for c in range(len(sub_mat[0])):
                matrix[r+r1-1][c+c1-1] = sub_mat[r][c]
 
    print(answer)
    return answer

def build_matrix(rows, cols):
    return [[cols*r + c+1 for c in range(cols)] for r in range(rows)]

solution(4, 3, [[1, 1, 2, 4, 3], [3, 2, 1, 2, 3], [4, 1, 1, 4, 3], [2, 2, 1, 3, 3]])