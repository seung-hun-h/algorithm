from collections import Counter
import re
def solution(str1, str2):
    str1 = [str1[i:i+2].lower() for i in range(len(str1)-1)\
             if len(re.sub('[^a-zA-Z]', '', str1[i:i+2])) > 1]
    str2 = [str2[i:i+2].lower() for i in range(len(str2)-1)\
             if len(re.sub('[^a-zA-Z]', '', str2[i:i+2])) > 1]

    count1 = Counter(str1)
    count2 = Counter(str2)

    _inter = count1.keys() & count2.keys()
    _union = count1.keys() | count2.keys()

    if not _inter and not _union:
        return 65536
    
    _inter_cnt = sum([min(count1[c], count2[c]) for c in _inter])
    _union_cnt = sum([max(count1[c], count2[c]) for c in _union])

    return int((_inter_cnt / _union_cnt) * 65536)

res = solution("FRANCE", "french")
print(res)