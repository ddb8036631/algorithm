def solution(n, lost, reserve):
    answer = 0
    cnt = [1] * n

    for l in lost:
        cnt[l - 1] -= 1
    for r in reserve:
        cnt[r - 1] += 1

    for idx in range(len(cnt)):
        if idx - 1 >= 0 and cnt[idx] >= 2 and cnt[idx - 1] == 0:
            cnt[idx - 1] += 1
            cnt[idx] -= 1
        if idx + 1 < len(cnt) and cnt[idx] >= 2 and cnt[idx + 1] == 0:
            cnt[idx + 1] += 1
            cnt[idx] -= 1

    for c in cnt:
        if c >= 1:
            answer += 1

    return answer


print(solution(5, [2, 4], [1, 3, 5]))
print(solution(5, [2, 4], [3]))
print(solution(3, [3], [1]))
