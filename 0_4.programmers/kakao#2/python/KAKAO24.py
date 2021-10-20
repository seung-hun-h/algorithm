def solution(n, build_frame):
    result = set()
    
    for x, y, a, b in build_frame:
        if b == 0: # 삭제
            result.remove((x, y, a))
                        
            if not is_valid(result):
                result.add((x, y, a))
                                
        else: # 설치
            result.add((x, y, a))
            
            if not is_valid(result):
                result.remove((x, y, a))
    
    return list(sorted(result, key = lambda x : [x[0], x[1], x[2]])) 

def is_valid(result):
    for x, y, a in result :
        if a == 0 : # 기둥
            if y == 0 or (x, y - 1, 0) in result or (x, y, 1) in result or (x - 1, y, 1) in result:
                continue
            return False
        else : # 보
            if (x, y - 1, 0) in result or (x + 1, y - 1, 0) in result or ((x - 1, y, 1) in result and (x + 1, y, 1) in result):
                continue
            return False
        
    return True

res = solution(5, [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]])
print(res)