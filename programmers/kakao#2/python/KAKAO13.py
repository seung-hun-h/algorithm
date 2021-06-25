from collections import Counter
import re
def solution(s):
    return list(map(int, [k for k, v in sorted(Counter(re.findall('\d+', s)).items(), key=lambda x: -x[1]) if k.isdigit()]))

"""
[카카오 2019 인턴] 튜플
해결: O
시간: 20분
"""