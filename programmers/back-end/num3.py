def solution(rows, columns, queries):
    answer = []
    matrix = make_matrix(rows, columns)
    
    for query in queries:
        matrix, _min = rotate(matrix, *query)

        answer.append(_min)  
        
    return answer

def rotate(matrix, x1, y1, x2, y2):
    #R1
    r1 = matrix[x1-1][y1-1:y2]
    temp = r1.pop()
    
    #C1
    c1 = [matrix[x][y2-1] for x in range(x1, x2-1)]
    c1 = [temp] + c1
    temp = c1.pop()
    
    #R2
    r2 = matrix[x2-1][y1-1:y2]
    r2.append(temp)
    temp, r2 = r2[0], r2[1:]
    
    #C2
    c2 = [matrix[x][y1-1] for x in range(x1, x2-1)]
    c2.append(temp)
    temp, c2 = c2[0], c2[1:]
    
    #R1
    r1 = [temp] + r1
    
    # 회전 반영
    matrix[x1-1][y1-1:y2] = r1
    matrix[x2-1][y1-1:y2] = r2
    for i, x in enumerate(range(x1, x2-1)):
        matrix[x][y2-1] = c1[i]
    for i, x in enumerate(range(x1, x2-1)):
        matrix[x][y1-1] = c2[i]
    
    _min = min(r1 + r2 + c1 + c2)

    return matrix, _min
    
def make_matrix(rows, columns):
    matrix = []
    
    for r in range(rows):
        matrix.append([])
        for c in range(columns):
            matrix[r].append(columns * r + c + 1)
        
    return matrix