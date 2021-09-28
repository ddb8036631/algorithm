def solution(absolutes, signs):
    return sum([absolute if sign else -absolute for absolute, sign in zip(absolutes, signs)])


print(solution([4, 7, 12], [True, False, True]))
print(solution([1, 2, 3], [False, False, True]))
