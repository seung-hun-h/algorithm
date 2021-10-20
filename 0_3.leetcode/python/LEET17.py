from typing import *

def letterCombinations(digits: str) -> List[str]:
    table = {
        '2': ['a', 'b', 'c'],
        '3': ['d', 'e', 'f'],
        '4': ['g', 'h', 'i'],
        '5': ['j', 'k', 'l'],
        '6': ['m', 'n', 'o'],
        '7': ['p', 'q', 'r', 's'],
        '8': ['t', 'u', 'v'],
        '9': ['w', 'x', 'y', 'z'],
    }

    def dfs(idx, _digits, result, results):
        if len(result) == len(_digits):
            results.append(result)
            return 
            
        for x in table[_digits[idx]]:
            dfs(idx+1, _digits, result+x, results)

        
    results = []
    if not len(digits):
        return results
    dfs(0, digits, "", results)
    return results

print(letterCombinations(""))