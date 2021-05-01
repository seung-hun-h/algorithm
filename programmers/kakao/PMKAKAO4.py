def solution(s):
    s = s[1:-1]
    numbers = []
    while s:
        if s.find("{") != -1:
            start = s.find("{")
            end = s.find("}")
            numbers.append(list(map(int, s[start+1:end].split(","))))
            s = s[end+1:]
    numbers.sort(key= lambda x : len(x))
    answer = []
    included = set()
    for i in range(len(numbers)):
        for num in numbers[i]:
            if num not in included:
                answer.append(num)
                included.add(num)

    
    return answer
from collections import Counter
import re
def solution2(s):
    return list(map(int, [k for k, v in sorted(Counter(re.findall('\d+', s)).items(), key=lambda x: -x[1]) if k.isdigit()]))
print(solution2("{{2},{2,1},{2,1,3},{2,1,3,4}}"))