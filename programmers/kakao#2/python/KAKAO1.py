"""
[카카오인턴] 키패드 누르기
해결: O
시간: 17분
유형: 브르투포스
"""

def solution(numbers, hand):
    answer = ""
    left, right = '*', '#'
    location = build_location() 
    
    for number in numbers:
        
        if number in [1, 4, 7]:
            answer += 'L'
            left = number
        elif number in [3, 6, 9]:
            answer += 'R'
            right = number
        else:
            left_dist = get_dist(number, left, location)
            right_dist = get_dist(number, right, location)

            if left_dist > right_dist:
                answer += "R"
                right = number
            elif left_dist < right_dist:
                answer += "L"
                left = number
            else:
                if hand == "right":
                    answer += "R"
                    right = number
                else:
                    answer += "L"
                    left = number

    return answer

def get_dist(num1, num2, location):
    row1, col1 = get_row_col(num1, location)
    row2, col2 = get_row_col(num2, location)

    return abs(row1 - row2) + abs(col1 - col2)

def get_row_col(num, location):
    return location[num] // 3, location[num] % 3

def build_location():
    location = dict()
    for i in range(1, 10):
        location[i] = i-1
    location[0] = 10
    location["*"] = 9
    location["#"] = 11
    
    return location

