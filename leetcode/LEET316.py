from typing import *

def removeDuplicateLetters(s: str) -> str:
    ans = ""
    for i in range(len(s)):
        idx = -1
        for j in range(len(ans)):
            if s[i] == ans[j]:
                idx = j
                break
        # Not duplicated
        if idx == -1:
            ans += s[i]
        else:
        # compare new string and old string
            if ans > ans[:idx]+ans[idx+1:]+s[i]:
                ans = ans[:idx]+ans[idx+1:]+s[i]
        print(ans)
    return ans

res = removeDuplicateLetters(s = "bcabc")
print(res)