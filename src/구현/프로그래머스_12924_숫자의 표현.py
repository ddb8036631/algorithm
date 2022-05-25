def solution(n):
    answer = 0
    for start in range(1, n + 1):
        sum = 0
        for next in range(start, n + 1):
            if sum + next >= n:
                if sum + next == n:
                    answer += 1
                break
            sum += next

    return answer


print(solution(15))
