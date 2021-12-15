import math

def solution(left, right):
    answer = 0
    for num in range(left, right + 1):
        sqrt = int(math.sqrt(num))
        if int(sqrt * sqrt) == num:
            answer -= num
        else:
            answer += num
    return answer

print(solution(13, 17))
print(solution(24, 27))
