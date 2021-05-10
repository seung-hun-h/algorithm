def solution(s):
    _dict = {"zero": 0, "one": 1, "two": 2, "three": 3, "four": 4, "five": 5,
                "six": 6, "seven":7, "eight": 8, "nine": 9}
    _str = s
    for num in _dict:
        if num in _str:
            _str = _str.replace(num, str(_dict[num]))
    print(_str)
    num = int(_str)
    return num
solution("one4seveneight")