from collections import defaultdict

def groupAnagrams(strs):
    words = defaultdict(list)
    for _str in strs:
        words[''.join(sorted(_str))].append(_str)

    return words.values()

strs = ["eat","tea","tan","ate","nat","bat"]
groupAnagrams(strs)