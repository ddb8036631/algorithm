def solution(N, stages):
    answer = []
    cnt = [0] * (N + 2)
    subsum = [0] * (N + 2)

    for stage in stages:
        cnt[stage] += 1

    subsum[N + 1] = cnt[N + 1]

    for i in range(N, 0, -1):
        subsum[i] = subsum[i + 1] + cnt[i]

    for i in range(1, N + 1):
        answer.append((cnt[i] / subsum[i] if subsum[i] != 0 else 0, i))

    return [*map(lambda x: x[1], sorted(answer, key=lambda x: -x[0]))]


print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
print(solution(4, [4, 4, 4, 4, 4]))
