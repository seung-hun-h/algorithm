from collections import defaultdict
def solution(numbers, hand):
    keys = defaultdict(int)
    for i in range(9):
        keys[i+1] = i
    keys["*"] = 9
    keys[0] = 10
    keys["#"] = 11
    ans = ''
    
    left = "*"
    right = "#"
    for number in numbers:
        if number in [1, 4, 7]:
            ans += "L"
            left = number
        elif number in [3, 6, 9]:
            ans += "R"
            right = number
        else:
            target_r, target_c = keys[number] // 3, keys[number] % 3
            left_r, left_c = keys[left] // 3, keys[left] % 3
            right_r, right_c = keys[right] // 3, keys[right] % 3
            
            left_dist = abs(target_r - left_r) + abs(target_c - left_c)
            right_dist = abs(target_r - right_r) + abs(target_c - right_c)
            if left_dist < right_dist:
                left = number
                ans += "L"
            elif left_dist > right_dist:
                right = number
                ans += "R"
            else:
                if hand == "right":
                    ans += "R"
                    right = number
                else:
                    ans += "L"
                    left = number
        
    return ans

solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left")