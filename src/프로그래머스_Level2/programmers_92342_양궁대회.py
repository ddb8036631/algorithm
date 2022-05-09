from itertools import combinations_with_replacement


def solution(n, info):
    max_diff = 0
    found = False

    for score in list(combinations_with_replacement(range(0, 11), n)):
        tmp = [0 for _ in range(11)]
        ryan, apeach = 0, 0

        for s in score:
            tmp[10 - s] += 1

        for i, (r, a) in enumerate(zip(tmp, info)):
            if r == a == 0:
                continue
            if r > a:
                ryan += 10 - i
            else:
                apeach += 10 - i

        if ryan > apeach:
            found = True
            diff = ryan - apeach

            if max_diff < diff:
                max_diff = diff
                answer = tmp

    return [-1] if not found else answer


print(solution(5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]))
print(solution(1, [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]))
print(solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]))
print(solution(10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3]))
